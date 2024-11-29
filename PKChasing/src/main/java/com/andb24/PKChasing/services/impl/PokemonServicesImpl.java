package com.andb24.PKChasing.services.impl;

import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.models.Pokemon;
import com.andb24.PKChasing.repository.PokemonRepository;
import com.andb24.PKChasing.services.PokemonServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonServicesImpl implements PokemonServices {
    private PokemonRepository pokemonRepository;


    public PokemonServicesImpl(PokemonRepository pokemonRepository)
    {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonDto> findAllPokemons() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        return pokemons.stream().map((pokemon) -> mapToPokemonDto(pokemon)).collect(Collectors.toList());
    }

    private PokemonDto mapToPokemonDto(Pokemon pokemon) {
        return PokemonDto.builder()
                .center(pokemon.getCenter())
                .name(pokemon.getName())
                .level(pokemon.getLevel())
                .isCaptured(pokemon.isCaptured())
                .type(pokemon.getType())
                .build();
    }
}
