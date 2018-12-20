package com.baufest.backend.controller;

import com.baufest.backend.model.SimpleBean;
import com.baufest.backend.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/simple")
public class SimpleController {

    private SimpleService service;

    @Autowired
    public SimpleController(SimpleService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    @ResponseStatus(code = HttpStatus.OK)
    public List<SimpleBean> getAll(){
        return this.service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public SimpleBean getById(@PathVariable("id") long id){
        return this.service.getById(id);
    }

    @PostMapping(value = "/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody SimpleBean bean){
        this.service.save(bean);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void save(@PathVariable("id") long id, @RequestBody SimpleBean bean){
        this.service.update(id, bean);
    }

}
