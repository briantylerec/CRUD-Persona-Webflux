package com.monksoft.webfluxdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monksoft.webfluxdemo.model.Persona;
import com.monksoft.webfluxdemo.repository.IPersonaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private IPersonaRepository personaRepo;

	@GetMapping("/listar")
	public Flux<Persona> listar(){
		return personaRepo.listar();
	}

	@PostMapping("/registrar/")
	Mono<Persona> registrar(@RequestBody Persona persona){
		return personaRepo.registrar(persona);
	}

	@PutMapping("modificar/")
    Mono<Persona> modificar(@RequestBody Persona persona){
		return personaRepo.modificar(persona);
	}

	@GetMapping("/listById/{id}")
	Mono<Persona> listarPorId(@PathVariable Integer id){
		return personaRepo.listarPorId(id);
	}

	@DeleteMapping("/delete/{id}")
    Mono<Void> eliminar(@PathVariable Integer id){
		return personaRepo.listarPorId(id)
				.flatMap(persona -> personaRepo.eliminar(persona.getIdPersona()));
	}
    
}
