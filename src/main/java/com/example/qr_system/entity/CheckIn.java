package com.example.qr_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;
    @ManyToOne
    private Activity activity;
    private LocalDateTime checkInTime;

    public CheckIn(User student, Activity activity, LocalDateTime now) {
    this.student= student;
    this.activity=activity;
    this.checkInTime=now;
    }

    public CheckIn() {
    }
}
