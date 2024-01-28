package com.marceloams.planets.service;

import com.marceloams.planets.dto.PlanetDTO;
import com.marceloams.planets.exceptions.ObjectNotFoundException;
import com.marceloams.planets.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public List<PlanetDTO> getAll(){
        return planetRepository.findAll().stream().map(PlanetDTO::create).toList();
    }

    public PlanetDTO getById(Long id){
        return planetRepository.findById(id).map(PlanetDTO::create).orElseThrow(() -> new ObjectNotFoundException("Planet not found!"));
    }

    public PlanetDTO getByName(String name){
        return planetRepository.findByName(name).map(PlanetDTO::create).orElseThrow(() -> new ObjectNotFoundException("Planet not found!"));
    }

}
