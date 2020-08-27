package com.udacity.course3.services;

import com.udacity.course3.data.entities.Plant;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant(null,"Rose", new BigDecimal("12.15"),null);
    }
}
