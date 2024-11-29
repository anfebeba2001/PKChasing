package com.andb24.PKChasing.repository;

import com.andb24.PKChasing.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByName(String name);

}
