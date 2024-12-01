package com.andb24.PKChasing.services;

import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.models.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface PokemonServices {
    List<PokemonDto> findAll();

    PokemonDto add(PokemonDto pokemonReceived);

    List<PokemonDto> findByType(String type);
}
