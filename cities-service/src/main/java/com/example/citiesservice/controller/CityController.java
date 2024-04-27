package com.example.citiesservice.controller;

import com.example.citiesservice.dto.CityDTO;
import com.example.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private ICityService cityServ;



    @GetMapping("/getCity")
    public CityDTO getCity(@RequestParam String nombre_ciudad, @RequestParam String pais){
        return cityServ.getCity(nombre_ciudad, pais);
    }

}
