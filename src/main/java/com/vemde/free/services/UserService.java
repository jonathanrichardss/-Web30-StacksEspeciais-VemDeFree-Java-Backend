package com.vemde.free.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vemde.free.dtos.UserDto;
import com.vemde.free.entities.UserEntity;
import com.vemde.free.repositories.UserRepository;

@Service
public class UserService {
	

	private final UserRepository repo;
	private final AuthService authService;
	
	@Autowired
	public UserService(UserRepository userRepository, AuthService authService) {
		this.repo = userRepository;
		this.authService = authService;
	}
	
	
	public UserDto create(UserDto dto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		UserEntity entity = new UserEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setGender(dto.getGender());
		entity.setIdProfile(dto.getIdProfile());
		entity.setNrCpfCnpj(dto.getNrCpfCnpj());
		entity.setPassword(authService.makeASecret(dto.getPassword()));
		entity.setBirthYear(dto.getBirthYear());
		entity.setIsActive(dto.getIsActive());
		entity.setEmail(dto.getEmail());
		
		repo.save(entity);
		
		return dto;
		
	}
	
	public List<UserEntity> getAllUsers() {
		return repo.findAll();
	}
	
	public UserEntity getByUserByEmailAndSecret(String email, String password) throws IllegalAccessException {
		
		var user = repo.findByEmailAndPassword(email, password);
	
		if (user != null) {
			return user;
		} else {
			throw new IllegalArgumentException("Usuário não encontrado");
		}
	
	}
	
	public Optional<UserEntity> getById(UUID id) {
		
		var user = repo.findById(id);
		
		return user;
	}


	public void deleteById(UUID userId) {
		repo.deleteById(userId);
	}
}
