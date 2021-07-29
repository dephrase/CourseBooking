package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourses(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name="customer", required = false) String customerName
    ){
        if(rating != null){
            return new ResponseEntity<>(courseRepository.getCoursesByRating(rating), HttpStatus.OK);
        } else if (customerName != null){
            return new ResponseEntity<>(courseRepository.getCoursesByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id) {
        return  new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

}
