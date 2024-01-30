package com.marceloams.planets.repository;

import com.marceloams.planets.model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrainRepository extends JpaRepository<Terrain, Long> {
    Terrain findByName(String name);
}
