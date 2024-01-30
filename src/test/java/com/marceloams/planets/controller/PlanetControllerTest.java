package com.marceloams.planets.controller;

import com.marceloams.planets.PlanetsApplication;
import com.marceloams.planets.dto.PlanetDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlanetsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlanetControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    private final String baseRequestUrl = "/api/v1/planets";

    private ResponseEntity<List<PlanetDTO>> getPlanets(){
        return restTemplate.exchange(
                baseRequestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PlanetDTO>>() {}
        );
    }

    private ResponseEntity<PlanetDTO> getPlanet(String url){
        return restTemplate.getForEntity(baseRequestUrl+url, PlanetDTO.class);
    }

    @Test
    public void getAll(){
        List<PlanetDTO> planetDTOS = getPlanets().getBody();
        Assertions.assertNotNull(planetDTOS);
        Assertions.assertEquals(2, planetDTOS.size());
    }

    @Test
    public void getById(){
        PlanetDTO planetDTO = getPlanet("/1").getBody();
        Assertions.assertNotNull(planetDTO);
        Assertions.assertEquals(1, planetDTO.getId());

        Assertions.assertEquals(HttpStatus.NOT_FOUND, getPlanet("/0").getStatusCode());
    }

    @Test
    public void getByName(){
        PlanetDTO planetDTO = getPlanet("/name/Tattoine").getBody();
        Assertions.assertNotNull(planetDTO);
        Assertions.assertEquals("Tattoine", planetDTO.getName());

        Assertions.assertEquals(HttpStatus.NOT_FOUND, getPlanet("/name/Non-existent").getStatusCode());
    }
}
