package com.example.football.models.entity;

import javax.persistence.*;

@Entity
@Table(name="stats")
public class Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float shooting;
    private float passing;
    private float endurance;

    public Stat() {}


    public Stat setId (long id) {
        this.id = id;
        return this;
    }

    public long getId() {
        return id;
    }

    public float getShooting() {
        return shooting;
    }

    public Stat setShooting(float shooting) {
        this.shooting = shooting;
        return this;
    }

    public float getPassing() {
        return passing;
    }

    public Stat setPassing(float passing) {
        this.passing = passing;
        return this;
    }

    public float getEndurance() {
        return endurance;
    }

    public Stat setEndurance(float endurance) {
        this.endurance = endurance;
        return this;
    }
}
