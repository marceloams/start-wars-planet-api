package com.marceloams.planets.service;

import com.marceloams.planets.dto.PlanetDTO;
import com.marceloams.planets.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlanetServiceTest {

    @Autowired
    PlanetService planetService;

    @Test
    public void getAll(){
        List<PlanetDTO> planetDTOS = planetService.getAll();
        Assertions.assertEquals(2, planetDTOS.size());
    }

    @Test
    public void getById(){
        PlanetDTO planetDTO = planetService.getById(1L);
        Assertions.assertNotNull(planetDTO);
        Assertions.assertEquals(1L, planetDTO.getId());

        Assertions.assertThrows(ObjectNotFoundException.class,() -> planetService.getById(0L));
    }

    @Test
    public void getByName(){
        PlanetDTO planetDTO = planetService.getByName("Tattoine");
        Assertions.assertNotNull(planetDTO);
        Assertions.assertEquals("Tattoine", planetDTO.getName());

        Assertions.assertThrows(ObjectNotFoundException.class,() -> planetService.getByName("NON_EXISTENT_NAME"));
    }

}
