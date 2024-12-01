package com.andb24.PKChasing.services.impl;

import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.mappers.CenterMapper;
import com.andb24.PKChasing.mappers.PokemonMapper;
import com.andb24.PKChasing.models.Pokemon;
import com.andb24.PKChasing.repository.CenterRepository;
import com.andb24.PKChasing.repository.PokemonRepository;
import com.andb24.PKChasing.services.CenterServices;
import com.andb24.PKChasing.services.PokemonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonServicesImpl implements PokemonServices {
    private  PokemonRepository pokemonRepository;
    private CenterRepository centerRepository;

    @Autowired
    public PokemonServicesImpl(PokemonRepository pokemonRepository, CenterRepository centerRepository)
    {
        this.pokemonRepository = pokemonRepository;
        this.centerRepository = centerRepository;

    }

    public List<PokemonDto> findAll() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        System.out.println("uwu");
        System.out.println(pokemonRepository.findAll());
        //Stream()? -> Used to process collections of objects, lists... maps...
            //a stream is a sequence of objects that supports various methods that can be
            //pipelined to produce the desired results.

        //map()?? -> Convert an object into a variation of the same with not all the attributes
            //Some other variations on the attributes

        //collect()?

        //Collectors class....? -> The Collector is an interface that provides a wrapper for
            // the supplier, accumulator, and combiner objects.

        PokemonMapper pokemonMapper = new PokemonMapper(centerRepository);
        return pokemons.stream().map(pokemonMapper::mapToPokemonDto).collect(Collectors.toList());

    }
    public List<PokemonDto> findByType(String type) {
        List<Pokemon> pokemons = pokemonRepository.findByType(type);
        PokemonMapper pokemonMapper = new PokemonMapper(centerRepository);
        return pokemons.stream().map(pokemonMapper::mapToPokemonDto).collect(Collectors.toList());
    }

    public PokemonDto add(PokemonDto pokemonReceived) {
        CenterMapper centerMapper = new CenterMapper(centerRepository);
        Pokemon pokemon = Pokemon.builder()
            .center(centerMapper.mapToCenter(pokemonReceived.getCenterDto()))
            .name(pokemonReceived.getName())
                .type(pokemonReceived.getType())
                .level(pokemonReceived.getLevel())
                    .build();

        pokemonRepository.save(pokemon);
        PokemonMapper pokemonMapper = new PokemonMapper(centerRepository);
        return pokemonMapper.mapToPokemonDto(pokemon);

    }







}
