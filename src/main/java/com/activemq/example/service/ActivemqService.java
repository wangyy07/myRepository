package com.activemq.example.service;

import com.activemq.example.mapper.ActivemqMapper;
import com.activemq.example.pojo.Teacher;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class ActivemqService {

    @Autowired private ActivemqMapper activemqMapper;
    @Autowired private JmsMessagingTemplate jmsTemplate;

    public Integer updateTeacherNameById(Long id) {

        Destination destination = new ActiveMQTopic("updateTeacherName1");

        Integer i = activemqMapper.updateTeacherNameById(id);
        Teacher teacher = activemqMapper.selectTeacherById(id);
        jmsTemplate.convertAndSend(destination, id);
        //jmsTemplate.convertAndSend(destination, teacher);
        System.out.println("i的值" + i + teacher);
        return i;
    }
    public Teacher findTeacher(Long id) {
        Teacher teacher = activemqMapper.selectTeacherById(id);
        return teacher;
    }
    public Integer updateTeacherNameForStu(Teacher teacher) {
        Integer i = activemqMapper.updateTeacherNameForStu(teacher);
        return i;
    }
}
