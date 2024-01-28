package com.marceloams.planets.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String climate;
    private String terrain;
    @Column(name = "movie_appearances_number")
    private int movieAppearancesNumber;
}
