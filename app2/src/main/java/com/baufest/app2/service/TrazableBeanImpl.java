package com.baufest.app2.service;

import com.baufest.app1.model.SimpleBean;
import com.baufest.app2.model.TrazableBean;
import com.baufest.app2.repository.TrazableBeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class TrazableBeanImpl implements TrazableBeanService {

    private TrazableBeanRepository repository;

    @Autowired
    public TrazableBeanImpl(TrazableBeanRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(SimpleBean bean) {
        TrazableBean trazableBean = new TrazableBean();
        trazableBean.setCreatedAt(new Date(Calendar.getInstance().getTime().getTime()));
        trazableBean.setName(bean.getName());

        this.repository.save(trazableBean);
    }

    @Override
    public List<TrazableBean> getAll() {
        return this.repository.findAll();
    }

    @Override
    public TrazableBean getById(long id) {
        Optional<TrazableBean> simpleBean = this.repository.findById(id);
        return simpleBean.isPresent() ? simpleBean.get() : null;
    }
}
