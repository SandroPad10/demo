package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
	
public Persona findByApellido(String nombre);	
public Persona findByEmail(String email);	


}
