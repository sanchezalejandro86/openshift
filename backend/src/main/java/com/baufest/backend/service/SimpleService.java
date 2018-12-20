package com.baufest.backend.service;

import com.baufest.backend.model.SimpleBean;

import java.util.List;

public interface SimpleService {

    List<SimpleBean> getAll();

    SimpleBean getById(long id);

    void save(SimpleBean bean);

    void update(long id, SimpleBean bean);
}
