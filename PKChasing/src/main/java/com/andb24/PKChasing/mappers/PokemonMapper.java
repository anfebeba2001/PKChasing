package com.andb24.PKChasing.mappers;

import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.models.Pokemon;
import com.andb24.PKChasing.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PokemonMapper {
    private CenterRepository centerRepository;
    @Autowired
    public PokemonMapper(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }
    public PokemonDto mapToPokemonDto(Pokemon pokemon) {
        CenterMapper centerMapper = new CenterMapper(centerRepository);
        return PokemonDto.builder()
                .centerDto(centerMapper.mapToCenterDto(pokemon.getCenter()))
                .name(pokemon.getName())
                .level(pokemon.getLevel())
                .isCaptured(pokemon.isCaptured())
                .type(pokemon.getType())
                .build();
    }

}
