package com.codeclan.example.CourseBookingSystem;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.CourseRating;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}


}
