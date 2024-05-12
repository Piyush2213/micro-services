package com.microservices.employeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String employeId;
    private String lane1;
    private String lane2;
    private String state;
    private String zip;

}
