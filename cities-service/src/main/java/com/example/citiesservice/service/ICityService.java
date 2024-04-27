package com.example.citiesservice.service;

import com.example.citiesservice.dto.CityDTO;
import com.example.citiesservice.model.City;

import java.util.List;

public interface ICityService {

    public CityDTO getCity(String nombre_ciudad, String pais);
}
