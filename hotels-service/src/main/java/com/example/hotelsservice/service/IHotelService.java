package com.example.hotelsservice.service;

import com.example.hotelsservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IHotelService {

    public List<Hotel> getHotels(Long id_ciudad);

}
