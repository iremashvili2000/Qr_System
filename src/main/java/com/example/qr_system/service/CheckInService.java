package com.example.qr_system.service;

import com.example.qr_system.entity.Activity;
import com.example.qr_system.entity.CheckIn;
import com.example.qr_system.entity.User;
import com.example.qr_system.repository.ActivityRepository;
import com.example.qr_system.repository.CheckInRepository;
import com.example.qr_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean performCheckIn(User student, Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        if (checkInRepository.findByStudentAndActivity(student, activity).isPresent()) {
            throw new RuntimeException("Already checked in");
        }

        CheckIn checkIn = new CheckIn(student, activity, LocalDateTime.now());
        checkInRepository.save(checkIn);
        return true;
    }


    public List<Activity> getCurrentActivities(Long classroomId) {
        LocalDateTime now = LocalDateTime.now();
        return activityRepository.findCurrentActivities(classroomId, now, now.minusMinutes(10));
    }



    public void checkIn(Long activityId, String studentId) {
        CheckIn checkIn = new CheckIn();
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        User user = userRepository.findById(Long.getLong(studentId))
                .orElseThrow(() -> new RuntimeException("Student not found"));

        checkIn.setActivity(activity);
        checkIn.setStudent(user);
        checkIn.setCheckInTime(LocalDateTime.now());
        checkInRepository.save(checkIn);
    }


}
