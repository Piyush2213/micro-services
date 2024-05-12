package com.microservices.addressservice.service;

import com.microservices.addressservice.entity.Address;
import com.microservices.addressservice.repo.AddressRepository;
import com.microservices.addressservice.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<AddressResponse> getAddressByEmployeeId(String employeId) {
        // Fetch addresses from the database by employeId
        List<Address> addresses = addressRepository.findByEmployeId(employeId);

        // List to hold AddressResponse objects
        List<AddressResponse> addressResponses = new ArrayList<>();

        // Map each Address entity to AddressResponse
        for (Address address : addresses) {
            AddressResponse response = new AddressResponse();
            response.setEmployeId(address.getEmployeId());
            response.setLane1(address.getLane1());
            response.setLane2(address.getLane2());
            response.setState(address.getState());
            response.setZip(address.getZip());
            addressResponses.add(response);
        }

        return addressResponses;
    }

}