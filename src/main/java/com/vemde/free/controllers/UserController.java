package com.vemde.free.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vemde.free.dtos.UserDto;
import com.vemde.free.entities.UserEntity;
import com.vemde.free.exceptions.TrueException;
import com.vemde.free.services.AuthService;
import com.vemde.free.services.UserService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
@RestController
public class UserController {
	
	
	
	private final UserService service;
	
	@Autowired
	public UserController(UserService userService) {
		this.service = userService;
	}
	
	
	@PostMapping("/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public UserDto create(@RequestBody UserDto dto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
				
		return service.create(dto);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> update(@RequestBody UserDto dto, @PathVariable UUID userId) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		var existsById = service.getById(userId);
		
		if (!existsById.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		dto.setId(userId);
		var user = service.create(dto);
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<UserDto> validateUser(@RequestBody UserDto dto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		UserDto newUser =  new UserDto();
		
		newUser.setEmail(dto.getEmail());
		newUser.setPassword(dto.getPassword());
		
		try {
		UserEntity validatedUser = service.getByUserByEmailAndSecret(newUser.getEmail(), AuthService.makeASecret(newUser.getPassword()));
		newUser.setId(validatedUser.getId());
		newUser.setName(validatedUser.getName());
		newUser.setAddress(validatedUser.getAddress());
		newUser.setBirthYear(validatedUser.getBirthYear());
		newUser.setGender(validatedUser.getGender());
		newUser.setNrCpfCnpj(validatedUser.getNrCpfCnpj());
		newUser.setIdProfile(validatedUser.getIdProfile());
		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(newUser);
	}
	
	
	@PostMapping("/validate/{token}")
	public ResponseEntity<UserEntity> validateUser(@PathVariable ("token") String token) {
		
		var user = service.getById(UUID.fromString(token));
		
		if (user.isEmpty()) {
			throw new TrueException("Usuário não é válido");
		}
		
		return ResponseEntity.ok(user.get());
	}
	
	
	@GetMapping("/users/list")
	public List<UserEntity> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable ("id") UUID id) {
				
		return service.getById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
				
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> delete(@PathVariable ("userId") UUID userId) {
		
		var existsById = service.getById(userId);
		if (!existsById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(userId);
		
		return ResponseEntity.noContent().build();
		
	}

}
