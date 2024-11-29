package com.andb24.PKChasing.dto;

import com.andb24.PKChasing.models.Center;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TrainerDto {
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;
}
