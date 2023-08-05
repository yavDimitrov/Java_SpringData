package com.example.football.models.entity;

import javax.persistence.*;

@Entity
@Table(name="teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name="stadium_name", nullable = false)
    private String stadiumName;

    @Column(name="fan_base", nullable = false)
    private int fanBase;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String history;

   public Team () {}

    public long getId() {
        return id;
    }

    public Team setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public Team setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
        return this;
    }

    public int getFanBase() {
        return fanBase;
    }

    public Team setFanBase(int fanBase) {
        this.fanBase = fanBase;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public Team setHistory(String history) {
        this.history = history;
        return this;
    }
}

