package com.example.qr_system.config;

import com.example.qr_system.entity.Activity;
import com.example.qr_system.entity.ActivityHistory;
import com.example.qr_system.repository.ActivityHistoryRepository;
import com.example.qr_system.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class ActivityHistoryComponent {


    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityHistoryRepository activityHistoryRepository;

    @Scheduled(cron = "0 0 3 * * ?") // Runs every day at 3:00 AM
    @Transactional
    public void archiveClosedActivities() {
        LocalDateTime now = LocalDateTime.now();
        List<Activity> closedActivities = activityRepository.findClosedActivities(now);

        for (Activity activity : closedActivities) {
            ActivityHistory history = new ActivityHistory();
            history.setName(activity.getName());
            history.setStartTime(activity.getStartTime());
            history.setEndTime(activity.getEndTime());
            history.setClassroom(activity.getClassroom());

            activityHistoryRepository.save(history);
            activityRepository.delete(activity); // Remove old activity
        }
    }


}
