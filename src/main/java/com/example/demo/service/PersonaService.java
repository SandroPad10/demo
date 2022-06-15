package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Persona;


public interface PersonaService {
	
	public List<Persona> getAll();
	public Persona getUser(String email) throws AccountNotFoundException;
	public Persona getId(String id);
	public Iterable<Persona> findAll();
	public Optional<Persona> findById(Integer id);
	public Persona save(Persona persona);
	public void deleteById(Integer id);
}