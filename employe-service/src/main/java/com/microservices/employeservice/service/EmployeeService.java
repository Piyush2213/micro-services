package com.microservices.employeservice.service;

import com.microservices.employeservice.entity.Address;
import com.microservices.employeservice.entity.Employee;
import com.microservices.employeservice.repo.EmployeeRepository;
import com.microservices.employeservice.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    AddressService addressService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
//        this.restTemplate = restTemplate;
    }

    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElse(null);

        if (employee != null) {
            EmployeeResponse response = new EmployeeResponse();
            response.setId(employee.getId());
            response.setEmployeeName(employee.getEmployeeName());
            response.setBloodGroup(employee.getBloodGroup());


            // using rest template to call another service...
//            ArrayList<Address> obj = restTemplate.getForObject("http://address-service/address/" + employee.getId(), ArrayList.class);


            //using feign client instead of rest Template
            List<Address> address = addressService.getAddress(employee.getId());
            response.setAddress(address);
            return response;

        } else {
            return null;
        }
    }
}
