package com.andb24.PKChasing.repository;

import com.andb24.PKChasing.models.Capture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface CaptureRepository extends JpaRepository<Capture, Long> {
    List<Capture> findAllByCaptureDateBetween(Date from, Date to);

    @Override
    List<Capture> findAll();
}
