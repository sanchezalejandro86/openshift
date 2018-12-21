package com.baufest.backend.service;

import com.baufest.backend.model.SimpleBean;
import com.baufest.backend.repository.SimpleBeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleServiceImpl implements SimpleService {

    private final SimpleBeanRepository repository;

    @Autowired
    public SimpleServiceImpl(SimpleBeanRepository repository) {
        this.repository = repository;
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
    }

    @Override
    public void update(long id, SimpleBean bean) {
        bean.setId(id);
        this.repository.save(bean);
    }
}
