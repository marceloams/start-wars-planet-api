package com.marceloams.planets.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String climate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "planet_terrains",
            joinColumns = @JoinColumn(name = "planet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "terrain_id", referencedColumnName = "id")
    )
    private List<Terrain> terrains;

    @Column(name = "movie_appearances_number")
    private int movieAppearancesNumber;
}
