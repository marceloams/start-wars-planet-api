package com.marceloams.planets.service;

import com.marceloams.planets.model.swapi.PlanetSWAPI;
import com.marceloams.planets.model.swapi.ResponseSWAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@Service
public class SwapiService {

    @Autowired
    WebClient webClient;

    private static final Logger logger = LogManager.getLogger(ResponseSWAPI.class);

    private Flux<ResponseSWAPI> getPlanetsResponse(String uri) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(ResponseSWAPI.class)
                .doOnError(throwable -> logger.error("Failed for some reason", throwable));
    }

    public int getMovieAppearancesNumber(String planetName) {

        String uri = "https://swapi.dev/api/planets";

        while(uri!=null){
            ResponseSWAPI responseSWAPI = getPlanetsResponse(uri).blockFirst();
            assert responseSWAPI != null;

            List<PlanetSWAPI> planetSWAPIs = responseSWAPI.getPlanets().stream().filter(planetSWAPI -> Objects.equals(planetSWAPI.getName(), planetName)).toList();

            if(!planetSWAPIs.isEmpty())
                return planetSWAPIs.get(0).getFilms().size();

            uri = responseSWAPI.getNext();
        }

        return 0;
    }
}
