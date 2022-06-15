package com.example.demo.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;

class PersonaServiceImplTest {

		@InjectMocks
		PersonaServiceImpl service;
	
	@Mock
	private PersonaRepository repository;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
	}
	@Test
	final void testGetUser() {
		
		Persona persona1= new Persona();
		persona1.setId(1);
		persona1.setLast_name("Busch");
		persona1.setEmail("sandropadilla10@gmail.com");
		when(repository.findByEmail(anyString())).thenReturn(persona1);
		Persona persona = service.getUser("test@test.com");
		assertNotNull(persona);
		assertEquals("Padilla", persona.getLast_name());
	}

}
