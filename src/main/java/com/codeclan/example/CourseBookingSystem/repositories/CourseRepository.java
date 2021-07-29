package com.codeclan.example.CourseBookingSystem.repositories;

import com.codeclan.example.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> getCoursesByRating(Integer rating);

    List<Course> getCoursesByBookingsCustomerNameIgnoreCase(String customerName);
}
