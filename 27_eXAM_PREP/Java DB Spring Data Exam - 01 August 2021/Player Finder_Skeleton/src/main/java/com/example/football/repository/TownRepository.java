package com.example.football.repository;


import com.example.football.models.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

//ToDo:
public interface TownRepository extends JpaRepository<Town, Long> {
}
