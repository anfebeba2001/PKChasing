package com.andb24.PKChasing.mappers;

import com.andb24.PKChasing.dto.CenterDto;
import com.andb24.PKChasing.models.Center;
import com.andb24.PKChasing.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CenterMapper {
    CenterRepository centerRepository;
    @Autowired
    public CenterMapper(CenterRepository centerRepository)
    {
        this.centerRepository = centerRepository;
    }
    public Center mapToCenter(CenterDto centerDto)
    {
        Optional<Center> optCenter = centerRepository.findByName(centerDto.getName());

        if(optCenter.isPresent())
        {
            return optCenter.get();
        }
        else {
            System.out.println("error encontrando el centro pokemon");
            return null;
        }


    }

    public CenterDto mapToCenterDto(Center center)
    {
        return CenterDto.builder()
                .name(center.getName())
                .capturedPokemons(center.getCapturedPokemons())
                .level(center.getLevel())
                .location(center.getLocation())
                .trainers(center.getTrainers())
                .build();
    }
}
