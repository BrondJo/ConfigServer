package com.example.hotelsservice.controller;

import com.example.hotelsservice.model.Hotel;
import com.example.hotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    IHotelService hotelServ;

    @GetMapping("/{id_ciudad}")
    public List<Hotel> getHoteles(@PathVariable Long id_ciudad){
        return hotelServ.getHotels(id_ciudad);
    }

}
