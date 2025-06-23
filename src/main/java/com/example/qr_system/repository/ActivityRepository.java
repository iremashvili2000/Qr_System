package com.example.qr_system.repository;


import com.example.qr_system.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("SELECT a FROM Activity a WHERE a.classroom.qrCodeId = :qrCodeId " +
            "AND a.startTime BETWEEN :start AND :end")
    List<Activity> findCurrentActivities(String qrCodeId, LocalDateTime start, LocalDateTime end);


    @Query("SELECT a FROM Activity a WHERE a.endTime < :now")
    List<Activity> findClosedActivities(LocalDateTime now);

    @Query("SELECT a FROM Activity a WHERE a.classroom = :classroomId AND a.startTime <= :now AND a.endTime >= :minTime")
    List<Activity> findCurrentActivities(@Param("classroomId") Long classroomId, @Param("now") LocalDateTime now, @Param("minTime") LocalDateTime minTime);

}
