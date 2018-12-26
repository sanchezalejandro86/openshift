package com.baufest.app1.service;

import com.baufest.app1.model.SimpleBean;
import com.baufest.app1.repository.SimpleBeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleServiceImpl implements SimpleService {

    private final SimpleBeanRepository repository;

    private JmsTemplate jmsTemplate;

    @Value("${queue.beans}")
    private String queue;

    @Autowired
    public SimpleServiceImpl(SimpleBeanRepository repository, JmsTemplate jmsTemplate) {
        this.repository = repository;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public List<SimpleBean> getAll() {
        return this.repository.findAll();
    }

    @Override
    public SimpleBean getById(long id) {
        Optional<SimpleBean> simpleBean = this.repository.findById(id);
        return simpleBean.isPresent() ? simpleBean.get() : null;
    }

    @Override
    public void save(SimpleBean bean) {
        this.repository.save(bean);
        this.jmsTemplate.convertAndSend(queue, bean);
    }

    @Override
    public void update(long id, SimpleBean bean) {
        bean.setId(id);
        this.repository.save(bean);
    }

    @Override
    public void delete(long id) {
        this.repository.deleteById(id);
    }
}
