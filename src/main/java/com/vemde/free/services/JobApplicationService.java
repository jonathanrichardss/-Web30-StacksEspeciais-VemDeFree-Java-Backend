package com.vemde.free.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vemde.free.dtos.JobApplicationDto;
import com.vemde.free.entities.CardJobEntity;
import com.vemde.free.entities.JobApplicationEntity;
import com.vemde.free.entities.UserEntity;
import com.vemde.free.exceptions.TrueException;
import com.vemde.free.repositories.JobApplicationRepository;
import com.vemde.free.repositories.JobCardRepository;
import com.vemde.free.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class JobApplicationService {

	private final JobApplicationRepository repository;
	private final UserRepository userRepository;
	private final JobCardRepository cardRepository;
	
	@Autowired
	public JobApplicationService(JobApplicationRepository repository, UserRepository userRepository, JobCardRepository cardRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
		this.cardRepository = cardRepository;
	}
	
	@Transactional
	public JobApplicationEntity create(JobApplicationDto dto) {
		
		JobApplicationEntity entity = new JobApplicationEntity();
		CardJobEntity cardJobEntity = new CardJobEntity();
		UserEntity userEntity = new UserEntity();
		
		userEntity.setId(dto.getUser().getId());		
		cardJobEntity.setId(dto.getCardJob().getId());
		entity.setId(dto.getId());
		entity.setEstimatedTime(dto.getEstimatedTime());
		entity.setApplicationDate(dto.getApplicationDate());
		
		var userById = userRepository.findById(dto.getUser().getId());
		var cardJobById = cardRepository.findById(dto.getCardJob().getId());
		
		if(!userById.isPresent()) {
			throw new TrueException("O usuário informado não existe/não foi encontrado.");
		}
		
		if(!cardJobById.isPresent()) {
			throw new TrueException("O job informado não existe/não foi encontrado.");
		}
		
		entity.setUser(userById.get());
		entity.setCardJob(cardJobById.get());
		
		userRepository.save(entity.getUser());
		cardRepository.save(entity.getCardJob());
		
		return repository.saveAndFlush(entity);

	}
	
	
	@Transactional
	public void delete(UUID id) throws IllegalAccessException {
		if (id == null) {
			throw new IllegalAccessException("O id informado não existe/inválido.");
		}
		
		repository.deleteById(id);
	}
	
	public List<JobApplicationEntity> getAllJobApplications() {
		return repository.findAll();
	}

	public Optional<JobApplicationEntity> getById(UUID id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public void deleteById(UUID jobApplyId) {
		// TODO Auto-generated method stub
		boolean existsById = repository.existsById(jobApplyId);
		
		if (!existsById) {
			throw new TrueException("Job não encontrado ou inexistente");
		}
		
		repository.deleteById(jobApplyId);
	}
	
	
}
