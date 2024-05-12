package com.microservices.addressservice.controller;

import com.microservices.addressservice.response.AddressResponse;
import com.microservices.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/{employeId}")
    public ResponseEntity<List<AddressResponse>> getAddressByEmployeeId(@PathVariable String employeId) {
        List<AddressResponse> response = addressService.getAddressByEmployeeId(employeId);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
