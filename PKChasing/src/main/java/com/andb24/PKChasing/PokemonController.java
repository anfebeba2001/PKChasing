package com.andb24.PKChasing;

import com.andb24.PKChasing.services.PokemonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokemonController {
    private PokemonServices pokemonServices;

    @Autowired
    public PokemonController(PokemonServices pokemonServices) {
        this.pokemonServices = pokemonServices;
    }

    @GetMapping("/pokemons")
}
