package com.example.qr_system.controller;

import com.example.qr_system.entity.Activity;
import com.example.qr_system.entity.User;
import com.example.qr_system.service.CheckInService;
import com.example.qr_system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkin")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;
    @Autowired
    private TokenService tokenService;

/*

    @GetMapping("/activities/{classroomId}")
    public List<Activity> getActivities(@PathVariable Long classroomId) {
        return checkInService.getCurrentActivities(classroomId);
    }


    @PostMapping("/check-in")
    public ResponseEntity<?> checkIn(@RequestParam Long activityId, @AuthenticationPrincipal Jwt principal) {
        String studentId = principal.getSubject(); // retrieves the "sub" claim
        checkInService.checkIn(activityId, studentId);
        return ResponseEntity.ok().build();
    }

 */



    @PostMapping("/{activityId}")
    public ResponseEntity<String> checkIn(@AuthenticationPrincipal User student, @PathVariable Long activityId, @RequestHeader("Session-Token") String token) {
        if (!tokenService.validateToken(student.getId(), token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid session token");
        }

        checkInService.performCheckIn(student, activityId);
        return ResponseEntity.ok("Check-in successful");
    }





}
