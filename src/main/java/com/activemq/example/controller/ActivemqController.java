package com.activemq.example.controller;

import com.activemq.example.service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivemqController {

    @Autowired private ActivemqService activemqService;

    @RequestMapping("/test")
    public String testCon() {
        Long id = 1L;
        activemqService.updateTeacherNameById(id);
        return "123";
    }
}
