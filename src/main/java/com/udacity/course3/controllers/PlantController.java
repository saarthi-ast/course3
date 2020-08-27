package com.udacity.course3.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.course3.data.dto.PlantDTO;
import com.udacity.course3.data.dto.Views;
import com.udacity.course3.data.entities.Plant;
import com.udacity.course3.services.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping("/dto")
    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant,plantDTO);
        return plantDTO;
    }

    @JsonView(Views.class)
    @GetMapping("/view")
    public Plant getFilteredPlant(String name){
        Plant plant = plantService.getPlantByName(name);
        return plant;
    }

}
