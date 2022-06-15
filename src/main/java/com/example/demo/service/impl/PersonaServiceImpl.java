package com.example.demo.service.impl;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository repository;

	@Override
	public List<Persona> getAll() {

		return repository.findAll();

	}
	
	@Override
	public Persona getUser(String email) throws AccountNotFoundException {
		Persona persona = repository.findByEmail(email);
		
		if(persona==null) 
			throw new AccountNotFoundException(email);
		Persona returnValue = new Persona();
		BeanUtils.copyProperties(persona, returnValue);
		return returnValue;
	}

	@Override
	public Persona getId(String id) {
		Persona persona1 = repository.findById(id);
		
		if(persona1==null) 
			throw new AccountNotFoundException();
		Persona returnValue = new Persona();
		BeanUtils.copyProperties(persona1, returnValue);
		return returnValue;
		
	}

	@Override
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Persona> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return repository.save(persona);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}


	

}