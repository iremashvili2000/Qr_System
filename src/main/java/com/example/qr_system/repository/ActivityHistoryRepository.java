package com.example.qr_system.repository;


import com.example.qr_system.entity.ActivityHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityHistoryRepository  extends JpaRepository<ActivityHistory, Long> {
}
