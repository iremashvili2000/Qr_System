package com.example.qr_system.config;


import com.example.qr_system.entity.Activity;
import com.example.qr_system.entity.Classroom;
import com.example.qr_system.entity.User;
import com.example.qr_system.repository.ActivityRepository;
import com.example.qr_system.repository.ClassroomRepository;
import com.example.qr_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserDataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
    /*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void run(String... args) {


        if (classroomRepository.count() == 0) {
            Classroom class1 = new Classroom();
            class1.setQrCodeId("room101");

            Classroom class2 = new Classroom();
            class2.setQrCodeId("room102");

            classroomRepository.saveAll(List.of(class1, class2));

            // Default activities for the classrooms
            Activity activity1 = new Activity();
            activity1.setName("Math Class");
            activity1.setStartTime(LocalDateTime.now().minusHours(2));
            activity1.setEndTime(LocalDateTime.now().minusMinutes(30)); // Already finished
            activity1.setClassroom(class1);

            Activity activity2 = new Activity();
            activity2.setName("Physics Class");
            activity2.setStartTime(LocalDateTime.now().minusMinutes(10));
            activity2.setEndTime(LocalDateTime.now().plusHours(1)); // Ongoing
            activity2.setClassroom(class2);

            activityRepository.saveAll(List.of(activity1, activity2));
        }

        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setUsername("student1");
            user1.setPassword("{noop}password123"); // No encoding for testing
            user1.setRole("STUDENT");

            User user2 = new User();
            user2.setUsername("student2");
            user2.setPassword("{noop}password123");
            user2.setRole("STUDENT");

            userRepository.saveAll(List.of(user1, user2));
        }
    }

     */
}

