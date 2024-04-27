package com.example.citiesservice.service;

import com.example.citiesservice.dto.CityDTO;
import com.example.citiesservice.model.City;
import com.example.citiesservice.repository.IHotelApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{
    List<City> cities = new ArrayList<>();

    @Autowired
    private IHotelApi hotelApi;

    public void saveCity() {
        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));
    }


    public City findCity(String nombre_ciudad, String pais) {
        this.saveCity();
        for (City ciudad : cities) {
            if(ciudad.getName().equals(nombre_ciudad)){
                if(ciudad.getCountry().equals(pais)) {
                    return ciudad;
                }
            }
        }
        return null;
    }


    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCity")
    @Retry(name = "hotels-service")
    public CityDTO getCity(String nombre_ciudad, String pais) {
        City city = this.findCity(nombre_ciudad, pais);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity_id(city.getCity_id());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());
        cityDTO.setHotelList(hotelApi.getHotels(city.getCity_id()));
        //this.createException();
        return cityDTO;


    }

    public CityDTO fallbackGetCity (Throwable throwable){
        return new CityDTO(9999999L, "FALLIDO", "FALLIDO", "FALLIDO", "FALLIDO", null);
    }

    public void createException(){
        throw new IllegalArgumentException("Prueba Resiliencia y Circuit Braker");
    }
}
