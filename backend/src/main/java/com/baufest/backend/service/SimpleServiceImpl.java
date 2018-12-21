package com.baufest.backend.service;

import com.baufest.backend.model.SimpleBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleServiceImpl implements SimpleService {

    Map<Long, SimpleBean> db = new HashMap<>();

    public SimpleServiceImpl() {
        db.put(1L, new SimpleBean(1L, "Ale"));
        db.put(2L, new SimpleBean(2L, "Juan"));
    }

    @Override
    public List<SimpleBean> getAll() {
        List<SimpleBean> beans = new ArrayList<>();
        for(SimpleBean bean : db.values()){
            beans.add(bean);
        };
        return beans;
    }

    @Override
    public SimpleBean getById(long id) {
        return db.get(id);
    }

    @Override
    public void save(SimpleBean bean) {
        db.put(bean.getId(), bean);
    }

    @Override
    public void update(long id, SimpleBean bean) {
        db.get(id).setName(bean.getName());
    }
}
