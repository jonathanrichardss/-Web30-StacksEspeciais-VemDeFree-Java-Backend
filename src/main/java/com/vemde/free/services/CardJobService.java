package com.vemde.free.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vemde.free.entities.CardJobEntity;
import com.vemde.free.repositories.JobCardRepository;

@Service
public class CardJobService {
	
	private final JobCardRepository cardRepository;
	
	
	@Autowired
	public CardJobService(JobCardRepository repo) {
		this.cardRepository = repo;
	}
	
	
	public void saveAll(CardJobEntity cardJobEntity) {
		
//		
//		Optional<CardJobEntity> alreadyExists = cardRepository.findById(cardJobEntity.getId());
//		
//		if (alreadyExists != null) {
//			throw new IllegalArgumentException("Já existe um job com esse Id!");
//		}
		
		cardRepository.saveAndFlush(cardJobEntity);
	}
	
	public List<CardJobEntity> getAllCardJobs() {
		return cardRepository.findAll();
	}
	
	public Optional<CardJobEntity> getById(UUID id) {
		return cardRepository.findById(id);
	}
	
	
	
}
