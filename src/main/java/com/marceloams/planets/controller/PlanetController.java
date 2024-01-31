package com.marceloams.planets.controller;

import com.marceloams.planets.dto.PlanetDTO;
import com.marceloams.planets.model.Planet;
import com.marceloams.planets.service.PlanetService;
import com.marceloams.planets.service.SwapiService;
import com.marceloams.planets.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private SwapiService swapiService;

    @GetMapping
    public ResponseEntity<List<PlanetDTO>> getAll(){
        return ResponseEntity.ok(planetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> getById(@PathVariable Long id){
        PlanetDTO planetDTO = planetService.getById(id);

        return ResponseEntity.ok(planetDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PlanetDTO> getByName(@PathVariable String name){
        PlanetDTO planetDTO = planetService.getByName(name);

        return ResponseEntity.ok(planetDTO);
    }

    private URI getURI(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/api/v1/planets/{id}").buildAndExpand(id).toUri();
    }

    @PostMapping("/add")
    public ResponseEntity<PlanetDTO> add(@RequestBody Planet planet){
        Assert.isNull(planet.getId(), "Insertion not done, id must be null!");
        Assert.hasText(planet.getName(), "Insertion not done, planet name cannot be blank!");

        terrainService.getTerrainsByName(planet.getTerrains());

        planet.setMovieAppearancesNumber(swapiService.getMovieAppearancesNumber(planet.getName()));

        PlanetDTO planetDTO = planetService.add(planet);

        return ResponseEntity.created(getURI(planetDTO.getId())).build();
    }

}
