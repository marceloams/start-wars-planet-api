package com.marceloams.planets.model.swapi;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseSWAPI {

    private String next;
    @JsonAlias(value = "results")
    private List<PlanetSWAPI> planets;
}
