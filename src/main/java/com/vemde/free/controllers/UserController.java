package com.vemde.free.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vemde.free.dtos.UserDto;
import com.vemde.free.entities.UserEntity;
import com.vemde.free.services.UserService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
@RestController
public class UserController {
	
	
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping("/create/user")
	public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto dto) {
		
		UserDto newUser =  new UserDto();
		
		newUser.setId(UUID.randomUUID());
		newUser.setName(dto.getName());
		newUser.setAddress(dto.getAddress());
		newUser.setGender(dto.getGender());
		newUser.setIdProfile(dto.getIdProfile());
		newUser.setNrCpfCnpj(dto.getNrCpfCnpj());
		newUser.setPassword(dto.getPassword());
		newUser.setBirthYear(dto.getBirthYear());
		newUser.setIsActive(dto.getIsActive());
		newUser.setEmail(dto.getEmail());
		
		userService.createNewUser(newUser);
		
		return ResponseEntity.ok(newUser);
	}
	
	
	@GetMapping("/users/list-all")
	public List<UserEntity> getAllUsers() {
		return userService.getAllUsers();
	}
}
