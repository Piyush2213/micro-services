package com.microservices.employeservice.controller;

import com.microservices.employeservice.request.EmployeeRequest;
import com.microservices.employeservice.response.EmployeeResponse;
import com.microservices.employeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {

        EmployeeResponse response = employeeService.getEmployeeById(id);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
