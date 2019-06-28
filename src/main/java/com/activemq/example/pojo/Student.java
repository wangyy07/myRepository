package com.activemq.example.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_student")
@Getter
@Setter
public class Student implements Serializable {

    @Id
    private Long id;
    private String studentName;
    private Long teacherId;
    private String teacherName;
}
