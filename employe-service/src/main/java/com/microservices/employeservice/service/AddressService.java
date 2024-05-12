package com.microservices.employeservice.service;

import com.microservices.employeservice.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "ADDRESS-SERVICE")
public interface AddressService {
    @GetMapping("/address/{employeeId}")
    List<Address> getAddress(@PathVariable("employeeId") Long employeeId);


}
