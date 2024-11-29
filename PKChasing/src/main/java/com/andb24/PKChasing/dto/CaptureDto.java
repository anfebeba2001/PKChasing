package com.andb24.PKChasing.dto;

import com.andb24.PKChasing.models.Pokemon;
import com.andb24.PKChasing.models.Trainer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CaptureDto {
    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
}
