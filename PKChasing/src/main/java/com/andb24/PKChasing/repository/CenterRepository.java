package com.andb24.PKChasing.repository;

import com.andb24.PKChasing.models.Center;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CenterRepository extends JpaRepository<Center, Long> {
    Optional<Center> findByName(String centerName);
}
