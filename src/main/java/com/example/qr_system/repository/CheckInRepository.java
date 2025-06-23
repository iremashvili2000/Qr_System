package com.example.qr_system.repository;

import com.example.qr_system.entity.Activity;
import com.example.qr_system.entity.CheckIn;
import com.example.qr_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Optional<CheckIn> findByStudentAndActivity(User student, Activity activity);
}