package com.vemde.free.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vemde.free.dtos.UserDto;
import com.vemde.free.entities.UserEntity;
import com.vemde.free.repositories.UserRepository;

@Service
public class UserService {
	

	private final UserRepository repository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.repository= userRepository;
	}
	
	
	public void createNewUser(UserDto dto) {
		
		UserEntity entity = new UserEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setGender(dto.getGender());
		entity.setIdProfile(dto.getIdProfile());
		entity.setNrCpfCnpj(dto.getNrCpfCnpj());
		entity.setPassword(dto.getPassword());
		entity.setBirthYear(dto.getBirthYear());
		entity.setIsActive(dto.getIsActive());
		entity.setEmail(dto.getEmail());
		
		if (repository.findById(entity.getId()).isPresent()) {
			throw new IllegalArgumentException("Usuário já cadastrado");
		} else {
			repository.save(entity);
		}
		
	}
	
	public List<UserEntity> getAllUsers() {
		return repository.findAll();
	}

}
