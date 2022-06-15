package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Persona;
import com.example.demo.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService service;
	
	@PostMapping (path="/users")
	public List<Persona> getAll(){
		return service.getAll();
	}
	
	//Crear un nuevo usuario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Persona persona){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(persona));
	}
	//Leer Usuario
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value ="id") Integer id){
		Optional<Persona> oPersona =service.findById(id);
		if(oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPersona);
	}

	//Eliminar Usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete( @PathVariable(value="id") Integer id){

		if(!service.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	//Leer Usuarios
	@GetMapping	
	public List<Persona> readAll(){
		
		List<Persona> personas= StreamSupport
				.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return personas;
	}
}
/* @GetMapping(path="/{id}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON){
		public PersonaController getUser(@PathVariable String id) {
			PersonaController returnValue= new PersonaController();
			
			Persona persona= service.getUser(id);
			returnValue= persona;
		}
	}
	

*/
	
	