package com.microservices.employeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = "employee_id")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", unique = true)
    private String employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Transient   // do not save this in db
    private List<Address> address = new ArrayList<>();


}
