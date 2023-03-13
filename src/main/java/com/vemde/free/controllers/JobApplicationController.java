package com.vemde.free.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vemde.free.dtos.JobApplicationDto;
import com.vemde.free.entities.JobApplicationEntity;
import com.vemde.free.services.JobApplicationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/applications")
@RestController
public class JobApplicationController {

	
	private final JobApplicationService service;
	
	@Autowired
	public JobApplicationController(JobApplicationService jobApplicationService) {
		this.service = jobApplicationService;
	}
	
	@PostMapping("/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<JobApplicationDto> createJobApply(@RequestBody JobApplicationDto dto) {
	
		service.create(dto);
		
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/update/{jobId}")
	public ResponseEntity<JobApplicationDto> saveJobApply(@RequestBody JobApplicationDto dto, @PathVariable ("jobId") UUID jobId) {
		
		
		var existsById = service.getById(jobId);
		
		if (!existsById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	
		dto.setId(jobId);
		service.create(dto);
		
		return ResponseEntity.ok(dto);
	}
	
	
	@JsonIgnore
	@GetMapping("/list")
	public List<JobApplicationEntity> getAll() {
		return service.getAllJobApplications();
	}
	
	@GetMapping("/{jobApplyId}")
	public ResponseEntity<JobApplicationEntity> getById(@PathVariable ("jobApplyId") UUID jobApplyId) {
		
		var existsById = service.getById(jobApplyId);
		
		if (!existsById.isPresent()) {
			ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(existsById.get());
	}
	
	@DeleteMapping("/delete/{jobApplyId}")
	public ResponseEntity<JobApplicationEntity> delete(@PathVariable ("jobApplyId") UUID jobApplyId) {
		if (jobApplyId == null) {
			throw new IllegalArgumentException("Id informado não existe ou não encontrado");
		}
		service.deleteById(jobApplyId);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
	}
	
}
