package com.andb24.PKChasing.services;

import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.models.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PokemonServices {
    List<PokemonDto> findAllPokemons();
    List<PokemonDto> findAllPokemonsByType(String type);
    Optional<PokemonDto> findPokemonById(Long id);
    List<PokemonDto> findAllPokemonsByIsCaptured(boolean isCaptured);
    List<PokemonDto> findAllPokemonsByLevel(int level);
    List<PokemonDto> findAllPokemonsByCenter_Id(long centerId);
}
