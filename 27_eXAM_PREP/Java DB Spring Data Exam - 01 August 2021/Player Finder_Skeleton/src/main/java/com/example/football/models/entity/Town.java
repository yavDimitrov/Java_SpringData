package com.example.football.models.entity;

import javax.persistence.*;

@Entity
@Table(name="towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, unique = true)
    private String name;

    private int population;

    @Column(name="travel_guide", nullable = false, columnDefinition = "TEXT")
    private String travelGuide;

    public Town() {
    }

    public long getId() {
        return id;
    }

    public Town setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

    public int getPopulation() {
        return population;
    }

    public Town setPopulation(int population) {
        this.population = population;
        return this;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public Town setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
        return this;
    }
}
