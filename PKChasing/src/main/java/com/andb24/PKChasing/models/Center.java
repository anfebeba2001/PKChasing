package com.andb24.PKChasing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "Center")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String Location;
    private int availablePokemons;
    private int capturedPokemons;
    private int trainers;
    private int level;
    @CreationTimestamp
    private LocalDateTime createdOn;
}
