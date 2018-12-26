package com.baufest.app1.service;

import com.baufest.app1.model.SimpleBean;

import java.util.List;

public interface SimpleService {

    List<SimpleBean> getAll();

    SimpleBean getById(long id);

    void save(SimpleBean bean);

    void update(long id, SimpleBean bean);
}
