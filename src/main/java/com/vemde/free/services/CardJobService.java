package com.vemde.free.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vemde.free.dtos.CardJobDto;
import com.vemde.free.entities.CardJobEntity;
import com.vemde.free.exceptions.TrueException;
import com.vemde.free.repositories.JobCardRepository;

@Service
public class CardJobService {
	
	private final JobCardRepository repo;
	
	
	@Autowired
	public CardJobService(JobCardRepository repo) {
		this.repo = repo;
	}
	
	


	public CardJobDto create(CardJobDto dto) {
		// TODO Auto-generated method stub
		
		CardJobEntity entity = new CardJobEntity() ;
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setRequiredExperience(dto.getRequiredExperience());
		entity.setCompanyName(dto.getCompanyName());
		entity.setCity(dto.getCity());
		entity.setIssueDate(dto.getIssueDate());
		entity.setTimeJob(dto.getTimeJob());
		entity.setPaymentValue(dto.getPaymentValue());
		
		repo.save(entity);
		
		return dto;
	}
	
	
	public void update(CardJobDto dto) {
		
		//CardJobEntity entity = new CardJobEntity();
		var existsById = repo.findById(dto.getId());
		
		if (!existsById.isPresent()) {
			throw new IllegalArgumentException("Job não encontrado ou não existe");
		}
		
		existsById.get().setTitle(dto.getTitle());
		existsById.get().setDescription(dto.getDescription());
		existsById.get().setRequiredExperience(dto.getRequiredExperience());
		existsById.get().setIssueDate(dto.getIssueDate());
		existsById.get().setTimeJob(dto.getTimeJob());
		existsById.get().setPaymentValue(dto.getPaymentValue());
		repo.save(existsById.get());
	}
	
	public List<CardJobEntity> getAllCardJobs() {
		return repo.findAll();
	}
	
	public Optional<CardJobEntity> getById(UUID id) {
		return repo.findById(id);
	}


	public void deleteById(UUID id) {
		// TODO Auto-generated method stub
		boolean existsById = repo.existsById(id);
		
		if (!existsById) {
			throw new TrueException("Job não encontrado ou inexistente");
		}
		
		repo.deleteById(id);
		
	}
}
