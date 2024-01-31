package com.marceloams.planets.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwapiServiceTest {

    @Autowired
    SwapiService swapiService;

    @Test
    public void getMovieAppearancesNumber(){
        //verify planet with 5 movie appearances
        Assertions.assertEquals(5, swapiService.getMovieAppearancesNumber("Tatooine"));
        //verify planet with 0 movie appearances
        Assertions.assertEquals(0, swapiService.getMovieAppearancesNumber("Ojom"));
        //verify planet with 0 movie appearances and that it is not in the SWAPI db
        Assertions.assertEquals(0, swapiService.getMovieAppearancesNumber("Random Planet"));
    }
}
