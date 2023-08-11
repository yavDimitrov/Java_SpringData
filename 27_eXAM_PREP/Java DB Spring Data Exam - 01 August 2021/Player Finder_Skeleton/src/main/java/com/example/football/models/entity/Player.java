package com.example.football.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(nullable = false)
    private PlayerPossition position;

    @ManyToOne(optional = false)
    private Town town;

    @ManyToOne(optional = false)
    private Team team;

    @OneToOne
    private Stat stat;


    public Player() {
    }

    public long getId() {
        return id;
    }

    public Player setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Player setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Player setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PlayerPossition getPosition() {
        return position;
    }

    public Player setPosition(PlayerPossition position) {
        this.position = position;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && Objects.equals(email, player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    public Player setTown(Town town) {
        this.town = town;
        return this;
    }

    public Player setTeam(Team team) {
        this.team = team;
        return this;
    }

    public Player setStat(Stat stat) {
        this.stat = stat;
        return this;
    }
}
