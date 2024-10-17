package com.harsh.atd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(length=50, nullable=false)
    private String studentName;

    @Column(length = 50, nullable=false)
    private String studentEmail;
    
    @Column(unique = true, length=10, nullable=false)
    private String studentNo;

    @Embedded
    private Address address;
}
