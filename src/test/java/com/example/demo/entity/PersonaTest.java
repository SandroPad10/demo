package com.example.demo.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.repository.PersonaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class PersonaTest {

	
	@Autowired
	private PersonaRepository repository;
	
	@Test
	@Rollback(false)
	public void testGuardarPersona() {
		Persona persona=new Persona(7,"Padilla","sandropadilla10@gmail.com");
		Persona personaGuardada=repository.save(persona);
		
	assertNotNull(personaGuardada);
	}
	
	@Test
	public void testBuscarPersonaPorApellido() {
		String nombre ="Bluth";
		
		Persona persona= repository.findByApellido(nombre);
		assertThat(persona.getLast_name()).isEqualTo(nombre);
	}
	@Test
	public void testBuscarPersonaPorApellidoNoExistente() {
		String nombre ="Cabrera";
		
		Persona persona= repository.findByApellido(nombre);
		assertNull(persona);
		
	}

}
