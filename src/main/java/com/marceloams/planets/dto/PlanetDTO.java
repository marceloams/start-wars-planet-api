package com.marceloams.planets.dto;

import com.marceloams.planets.model.Planet;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PlanetDTO {
    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private int movieAppearancesNumber;

    public static PlanetDTO create(Planet planet){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(planet, PlanetDTO.class);
    }
}
