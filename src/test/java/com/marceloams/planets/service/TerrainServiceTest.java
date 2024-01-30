package com.marceloams.planets.service;

import com.marceloams.planets.model.Terrain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TerrainServiceTest extends TerrainService{

    @Test
    public void getTerrainsByName(){
        //create new terrain
        Terrain newTerrain = new Terrain();
        newTerrain.setName("rainforest");

        //verify that not exists
        Assertions.assertNull(getByName(newTerrain.getName()));

        //get existent terrain
        Terrain existentTerrain = getByName("desert");

        //verify if exists
        Assertions.assertNotNull(existentTerrain);
        Assertions.assertEquals(1, existentTerrain.getId());
        Assertions.assertEquals("desert", existentTerrain.getName());

        //create a list of both
        List<Terrain> terrains = new ArrayList<>(List.of(newTerrain, existentTerrain));

        //get terrains with each id
        getTerrainsByName(terrains);

        //verify if geTerrainsByName worked
        Assertions.assertNotNull(terrains.get(0));
        Assertions.assertEquals(3, terrains.get(0).getId());
        Assertions.assertNotNull(terrains.get(1));
        Assertions.assertEquals(1, terrains.get(1).getId());
    }

}
