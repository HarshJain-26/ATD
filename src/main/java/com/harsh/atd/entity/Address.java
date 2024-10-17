package com.harsh.atd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    @Column(length = 30, nullable = false)
    private String state;

    @Column(length = 30, nullable = false)
    private String city;
    
    @Column(length = 6, nullable = false)
    private String pincode;
}
