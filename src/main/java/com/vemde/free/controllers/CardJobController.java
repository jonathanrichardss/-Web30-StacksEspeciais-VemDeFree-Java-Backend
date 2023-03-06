package com.vemde.free.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vemde.free.entities.CardJobEntity;
import com.vemde.free.services.CardJobService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/jobs")
@RestController
public class CardJobController {
	
	
	private final CardJobService service;
	
	@Autowired
	public CardJobController(CardJobService cardJobService) {
		this.service = cardJobService;
	}
	
	@PostMapping("/criar")
	public void save(@RequestBody CardJobEntity jobEntity) {
		
		CardJobEntity entity = new CardJobEntity() ;
		entity.setId(jobEntity.getId());
		entity.setTitle(jobEntity.getTitle());
		entity.setDescription(jobEntity.getDescription());
		entity.setRequiredExperience(jobEntity.getRequiredExperience());
		entity.setIssueDate(LocalDate.now());
		entity.setTimeJob(LocalDate.now());
		service.saveAll(entity);
	}
	
	@GetMapping("/listar-todos")
	public List<CardJobEntity> getAll() {
		return service.getAllCardJobs();
	}
}
