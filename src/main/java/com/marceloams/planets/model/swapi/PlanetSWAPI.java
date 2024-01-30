package com.marceloams.planets.model.swapi;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;

@Data
@JsonRootName(value = "results")
public class PlanetSWAPI {
    private String name;
    private List<String> films;
}
