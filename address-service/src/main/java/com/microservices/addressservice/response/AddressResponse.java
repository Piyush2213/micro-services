package com.microservices.addressservice.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddressResponse {
    private String employeId;
    private String lane1;
    private String lane2;
    private String state;
    private String zip;
}
