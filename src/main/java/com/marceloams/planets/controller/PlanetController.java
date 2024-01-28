package com.marceloams.planets.controller;

import com.marceloams.planets.dto.PlanetDTO;
import com.marceloams.planets.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planets")
public class PlanetController {

    @Autowired
    PlanetService planetService;

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

}
