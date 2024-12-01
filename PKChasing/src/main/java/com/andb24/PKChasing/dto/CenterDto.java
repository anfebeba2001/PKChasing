package com.andb24.PKChasing.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class CenterDto {
    private String name;
    private String location;
    private int capturedPokemons;
    private int trainers;
    private int level;
}
