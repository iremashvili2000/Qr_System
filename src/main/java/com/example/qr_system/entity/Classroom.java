package com.example.qr_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qrCodeId;

    @OneToMany(mappedBy = "classroom")
    private List<Activity> activities;
}