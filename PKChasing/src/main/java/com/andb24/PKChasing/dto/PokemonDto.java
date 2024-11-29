package com.andb24.PKChasing.dto;

import com.andb24.PKChasing.models.Center;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PokemonDto {
    private String name;
    private String type;
    private int level;
    private boolean isCaptured;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;
}
