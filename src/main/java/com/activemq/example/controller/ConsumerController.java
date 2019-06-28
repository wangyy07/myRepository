package com.activemq.example.controller;

import com.activemq.example.pojo.Teacher;
import com.activemq.example.service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired private ActivemqService activemqService;

    @JmsListener(destination = "updateTeacherName1")
    public void readActiveTopic(String message) {
        Long id = Long.parseLong(message);
        Teacher teacher = activemqService.findTeacher(id);
        Integer integer = activemqService.updateTeacherNameForStu(teacher);
    }

    @JmsListener(destination = "updateTeacherName")
    public void readActiveTopic2(String message) {
        System.out.println(message);
    }
}
