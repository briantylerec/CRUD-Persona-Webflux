package com.monksoft.webfluxdemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    private Integer idPersona;
    private String nombre;

    public Persona(Integer idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + "]";
    }

    
}