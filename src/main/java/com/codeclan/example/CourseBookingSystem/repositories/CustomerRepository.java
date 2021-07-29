package com.codeclan.example.CourseBookingSystem.repositories;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getCustomersByBookingsCourseNameIgnoreCase(String courseName);

    List<Customer> getCustomersByTownAndBookingsCourseNameAllIgnoreCase(String town, String courseName);

    List<Customer> getCustomersByAgeGreaterThanAndTownAndBookingsCourseNameAllIgnoreCase(Integer age, String town, String courseName);
}
