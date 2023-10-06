package com.codingbox.Springtest.student;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student {
    private Long id;
    private String studentName;
    private Integer age;
    private Integer subject;
    private String phone;
    private String addr;

    public Student() {
        super();
    }

    public Student(String studentName, Integer age, Integer subject, String phone, String addr) {
        super();
        this.studentName = studentName;
        this.age = age;
        this.subject = subject; 
        this.phone = phone;
        this.addr = addr;
    }
}
