package com.andb24.PKChasing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "capture")
public class Capture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon; // El Pokémon capturado

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer; // El entrenador que realizó la captura

    private LocalDateTime capturedAt; // Hora de la captura

    // Otros métodos o lógica si es necesario
}
