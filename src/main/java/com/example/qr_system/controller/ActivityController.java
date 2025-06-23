package com.example.qr_system.controller;

import com.example.qr_system.entity.Activity;
import com.example.qr_system.entity.User;
import com.example.qr_system.service.ActivityService;
import com.example.qr_system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/{qrCodeId}")
    public ResponseEntity<Map<String, Object>> getCurrentActivities(@PathVariable String qrCodeId, @AuthenticationPrincipal User student) {
        List<Activity> activities = activityService.getCurrentActivities(qrCodeId);
        String sessionToken = tokenService.generateToken(student.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("activities", activities);
        response.put("token", sessionToken);

        return ResponseEntity.ok(response);
    }


}
