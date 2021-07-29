package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.CourseRating;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        Course python = new Course("Python", "Glasgow", CourseRating.FIVESTAR);
        courseRepository.save(python);
        Course java = new Course("Java", "Glasgow", CourseRating.THREESTAR);
        courseRepository.save(java);
        Course csharp = new Course("C#", "Edinburgh", CourseRating.ONESTAR);
        courseRepository.save(csharp);
        Customer saad = new Customer("Saad", "Glasgow", 29);
        customerRepository.save(saad);
        Customer calum = new Customer("Calum", "Glasgow", 23);
        customerRepository.save(calum);
        Customer david = new Customer("David", "Glasgow", 29);
        customerRepository.save(david);
        Booking booking2 = new Booking("21/03/2021", java, david);
        Booking booking3 = new Booking("28/03/2021", python, david);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("23?09/2021", java, calum);
        bookingRepository.save(booking4);

        Booking booking1 = new Booking("14/08/2021", python, saad);
        bookingRepository.save(booking1);
    }


}
