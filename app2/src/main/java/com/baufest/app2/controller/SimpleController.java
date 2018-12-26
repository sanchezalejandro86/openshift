package com.baufest.app2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "simple")
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

    @GetMapping(value = "/{id}")
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
    public void update(@PathVariable("id") long id, @RequestBody SimpleBean bean){
        this.service.update(id, bean);
    }

}
