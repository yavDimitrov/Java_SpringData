package com.example.football.service.impl;

import com.example.football.service.TownService;
import org.springframework.stereotype.Service;


//ToDo - Implement all methods
@Service
public class TownServiceImpl implements TownService {


    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readTownsFileContent() {
        return null;
    }

    @Override
    public String importTowns() {
        return null;
    }
}
