package com.example.qr_system.service;

import com.example.qr_system.entity.Activity;
import com.example.qr_system.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getCurrentActivities(String qrCodeId) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusMinutes(10);
        LocalDateTime end = now.plusMinutes(10);
        return activityRepository.findCurrentActivities(qrCodeId, start, end);
    }
}
