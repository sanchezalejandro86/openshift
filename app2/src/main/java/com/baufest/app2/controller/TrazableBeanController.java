package com.baufest.app2.controller;

import com.baufest.app2.model.TrazableBean;
import com.baufest.app2.service.TrazableBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "trace")
public class TrazableBeanController {

    private TrazableBeanService service;

    @Autowired
    public TrazableBeanController(TrazableBeanService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TrazableBean> getAll(){
        return this.service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TrazableBean getById(@PathVariable("id") long id){
        return this.service.getById(id);
    }

}
