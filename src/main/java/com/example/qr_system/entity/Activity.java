package com.example.qr_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    @ManyToOne
    private Classroom classroom;

    public Activity(String math, LocalDateTime minusMinutes, LocalDateTime plusMinutes) {
        this.name=math;
        this.startTime=minusMinutes;
        this.endTime=plusMinutes;
    }

    public Activity() {
    }


}
