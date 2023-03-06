package com.vemde.free.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<JobApplicationDto> createJobApply(@RequestBody JobApplicationDto dto) {
		
		JobApplicationDto newJobApplication = new JobApplicationDto();
		
		newJobApplication.setCardJob(dto.getCardJob());
		newJobApplication.setUser(dto.getUser());
		newJobApplication.setId(dto.getId());
		newJobApplication.setApplicationDate(LocalDateTime.now());
		newJobApplication.setEstimatedTime(dto.getEstimatedTime());
		
		service.create(newJobApplication);
		
		return ResponseEntity.ok(newJobApplication);
	}
	
	@GetMapping("/list-all")
	public List<JobApplicationEntity> getAll() {
		return service.getAllJobApplications();
	}
}
