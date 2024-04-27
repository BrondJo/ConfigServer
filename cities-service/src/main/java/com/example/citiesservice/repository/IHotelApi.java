package com.example.citiesservice.repository;

import com.example.citiesservice.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service") //nombre del servicio
public interface IHotelApi {

    @GetMapping("hotels/{id_ciudad}") //se debe poner toda la url completa
    public List<HotelDTO> getHotels(@PathVariable ("id_ciudad") Long id_ciudad);

}
