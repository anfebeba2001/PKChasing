package com.andb24.PKChasing.repository;

import com.andb24.PKChasing.models.Capture;
import com.andb24.PKChasing.models.Pokemon;
import com.andb24.PKChasing.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




public interface CaptureRepository extends JpaRepository<Capture, Long> {



}
