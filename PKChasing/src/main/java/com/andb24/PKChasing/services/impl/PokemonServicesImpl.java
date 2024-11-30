package com.andb24.PKChasing.services.impl;

import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.models.Pokemon;
import com.andb24.PKChasing.repository.PokemonRepository;
import com.andb24.PKChasing.services.PokemonServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PokemonServicesImpl implements PokemonServices {
    private final PokemonRepository pokemonRepository;

    public PokemonServicesImpl(PokemonRepository pokemonRepository)
    {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonDto> findAllPokemons() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        //Stream()? -> Used to process collections of objects, lists... maps...
            //a stream is a sequence of objects that supports various methods that can be
            //pipelined to produce the desired results.

        //map()?? -> Convert an object into a variation of the same with not all the attributes
            //Some other variations on the attributes

        //collect()?

        //Collectors class....? -> The Collector is an interface that provides a wrapper for
            // the supplier, accumulator, and combiner objects.

        return pokemons.stream().map(this::mapToPokemonDto).collect(Collectors.toList());
    }

    public List<PokemonDto> findAllPokemonsByType(String type) {
        List<Pokemon> pokemons = pokemonRepository.findAllByType(type);
        return pokemons.stream().map(this::mapToPokemonDto).collect(Collectors.toList());
    }

    public Optional<PokemonDto> findPokemonById(Long id) {
        return Optional.empty();
    }

    public List<PokemonDto> findAllPokemonsByIsCaptured(boolean isCaptured) {
        return List.of();
    }

    public List<PokemonDto> findAllPokemonsByLevel(int level) {
        return List.of();
    }

    public List<PokemonDto> findAllPokemonsByCenter_Id(long centerId) {
        return List.of();
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
