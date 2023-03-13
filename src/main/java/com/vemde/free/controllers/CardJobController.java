package com.vemde.free.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vemde.free.dtos.CardJobDto;
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
	
	@PostMapping("/create")
	public ResponseEntity<CardJobDto> save(@RequestBody CardJobDto dto) {
		service.create(dto);
		
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CardJobDto> update(@RequestBody CardJobDto cardJobDto, @PathVariable ("jobId") UUID jobId) {
		
		
		var existsById = service.getById(jobId);
		
		if (!existsById.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		cardJobDto.setId(jobId);
		var job = service.create(cardJobDto); 
		
		return ResponseEntity.ok(job);
	}
	
	@GetMapping("/list")
	public List<CardJobEntity> getAll() {
		return service.getAllCardJobs();
	}
	
	@GetMapping("/{jobId}")
	public ResponseEntity<CardJobEntity> getById(@PathVariable ("jobId") UUID jobId) {
		
		return service.getById(jobId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{jobId}")
	public ResponseEntity<CardJobEntity> delete(@PathVariable ("jobId") UUID jobId) {
		if (jobId == null) {
			throw new IllegalArgumentException("Id informado não existe ou não encontrado");
		}
		service.deleteById(jobId);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
	}
}
