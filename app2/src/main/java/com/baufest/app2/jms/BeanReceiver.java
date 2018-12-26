package com.baufest.app2.jms;

import com.baufest.app1.model.SimpleBean;
import com.baufest.app2.dto.BeanDTO;
import com.baufest.app2.service.TrazableBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BeanReceiver {

    private TrazableBeanService trazableBeanService;

    @Autowired
    public BeanReceiver(TrazableBeanService trazableBeanService) {
        this.trazableBeanService = trazableBeanService;
    }

    @JmsListener(destination = "${queue.beans}")
    public void receiveMessage(SimpleBean bean) {
        System.out.println("Received: " + bean);
        this.trazableBeanService.save(bean);
    }
}
