package com.example.hotelsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private Long id_hotel;
    private String nombre;
    private int estrellas;
    private Long id_ciudad;
}
