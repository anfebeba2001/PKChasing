package com.andb24.PKChasing.controller;


import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.services.PokemonServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemons")
public class PokemonController {
    private PokemonServices pokemonServices;

    @Autowired
    public PokemonController(PokemonServices pokemonServices) {
        this.pokemonServices = pokemonServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PokemonDto>> getAll()
    {
        return new ResponseEntity<List<PokemonDto>>(pokemonServices.findAll(), HttpStatus.OK);
    }
    @GetMapping("/type/{type}")
    public ResponseEntity<List<PokemonDto>> getByType(@PathVariable String type)
    {
        return new ResponseEntity<List<PokemonDto>>(pokemonServices.findByType(type),HttpStatus.OK);
    }
    @PostMapping("/SavePokemon")
    public ResponseEntity<PokemonDto> addPokemon(@RequestBody PokemonDto pokemonReceived)
    {
        return new ResponseEntity<PokemonDto>(pokemonServices.add(pokemonReceived), HttpStatus.OK);
    }

}
