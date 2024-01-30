package com.marceloams.planets.dto;

import com.marceloams.planets.model.Planet;
import com.marceloams.planets.model.Terrain;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class PlanetDTO {
    private Long id;
    private String name;
    private String climate;
    private List<String> terrains;
    private int movieAppearancesNumber;

    public static PlanetDTO create(Planet planet){
        ModelMapper modelMapper = new ModelMapper();

        PlanetDTO planetDTO = modelMapper.map(planet, PlanetDTO.class);

        planetDTO.terrains = planet.getTerrains()
                                   .stream()
                                   .map(Terrain::getName)
                                   .toList();

        return planetDTO;
    }
}
