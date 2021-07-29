package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceUtil;
import java.beans.PersistenceDelegate;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(name = "course", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
    ){
        if (age != null && courseName != null && town != null){
            return new ResponseEntity<>(customerRepository.getCustomersByAgeGreaterThanAndTownAndBookingsCourseNameAllIgnoreCase(age, town, courseName), HttpStatus.OK);
        }
        else if(courseName != null && town != null){
            return new ResponseEntity<>(customerRepository.getCustomersByTownAndBookingsCourseNameAllIgnoreCase(town, courseName), HttpStatus.OK);
        }
        else if(courseName != null){
        return new ResponseEntity<>(customerRepository.getCustomersByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    }

    @GetMapping(value = "customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return  new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer currentCustomer = customerRepository.findById(id).get();
        currentCustomer.setName(customer.getName());
        currentCustomer.setTown(customer.getTown());
        currentCustomer.setAge(customer.getAge());
        customerRepository.save(currentCustomer);

        return new ResponseEntity<>(currentCustomer, HttpStatus.I_AM_A_TEAPOT);
    }
}
