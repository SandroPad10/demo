package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.AuthenticationController;
import com.example.demo.entity.Persona;
import com.example.demo.service.PersonaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class AuthenticationControllerTest {

	
	public MockMvc mockMvc;
	
	@Autowired
	public AuthenticationController authenticationController;
	@MockBean
	public PersonaService userService;
	
	private ObjectMapper objectMapper= new ObjectMapper();
	
	@BeforeEach
	public void SetUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
	}
	
	/*
	
	@Test
	void testSignUp() {
		
		SignUpDto.build=  SignUpDto.builder();
			.firtName("first")
			.lastName("Last")
			.login("Login")
			.password("pass".toCharArray())
			.build();
			
			
		when(PersonaService.signUp(any()))
		.thenReturn(.builder().id(1L)
				.firstName("first")
				.lastName("last")
				.token("token")
				.build());
		
		// when then
		mockMvc.perform(post("v1/signUp")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(ObjectMapper.writeValueAsBytes(signUpDto))
				) .andExpect(status().is(201))
					.andExpect(jsonPath("$.token",is("token")));
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
