package com.marceloams.planets.service;

import com.marceloams.planets.model.Terrain;
import com.marceloams.planets.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TerrainService {

    @Autowired
    private TerrainRepository terrainRepository;

    private Terrain add(String name){
        Assert.hasText(name, "Insertion not done, name must have some text!");

        return terrainRepository.save(new Terrain(name));
    }

    protected Terrain getByName(String name){
        return terrainRepository.findByName(name);
    }

    public void getTerrainsByName(List<Terrain> terrainNames){
        for(int i=0; i<terrainNames.size(); i++){
            Terrain terrain = getByName(terrainNames.get(i).getName());

            if(terrain == null)
                terrain = add(terrainNames.get(i).getName());

            terrainNames.set(i, terrain);
        }
    }

}
