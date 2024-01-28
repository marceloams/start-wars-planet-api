package com.marceloams.planets.repository;

import com.marceloams.planets.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);

}
