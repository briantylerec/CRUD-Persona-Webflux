package com.monksoft.webfluxdemo.repository.impl;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.monksoft.webfluxdemo.model.Persona;
import com.monksoft.webfluxdemo.repository.IPersonaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonaRepoImpl implements IPersonaRepository {

	private static final Logger log = LoggerFactory.getLogger(PersonaRepoImpl.class);

    @Override
    public Mono<Persona> registrar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Mono<Persona> modificar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Flux<Persona> listar() {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Pablo"));
        personas.add(new Persona(2, "Andres"));
        personas.add(new Persona(3, "Esteban"));

        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> listarPorId(Integer id) {
        return Mono.just(new Persona(id, "Juan"));
    }

    @Override
    public Mono<Void> eliminar(Integer id) {
        return Mono.empty();
    }   
}