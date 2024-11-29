package com.andb24.PKChasing.services;

import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.models.Pokemon;

import java.util.List;

public interface PokemonServices {
    List<PokemonDto> findAllPokemons();
}
