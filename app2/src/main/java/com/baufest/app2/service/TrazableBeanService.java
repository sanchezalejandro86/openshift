package com.baufest.app2.service;

import com.baufest.app2.dto.BeanDTO;
import com.baufest.app2.model.TrazableBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface TrazableBeanService {
    void save(BeanDTO bean);

    List<TrazableBean> getAll();

    TrazableBean getById(long id);

}
