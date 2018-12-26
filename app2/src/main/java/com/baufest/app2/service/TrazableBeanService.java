package com.baufest.app2.service;

import com.baufest.app1.model.SimpleBean;
import com.baufest.app2.model.TrazableBean;

import java.util.List;

public interface TrazableBeanService {
    void save(SimpleBean bean);

    List<TrazableBean> getAll();

    TrazableBean getById(long id);

}
