package com.vemde.free.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vemde.free.dtos.JobApplicationDto;
import com.vemde.free.entities.CardJobEntity;
import com.vemde.free.entities.JobApplicationEntity;
import com.vemde.free.entities.UserEntity;
import com.vemde.free.repositories.JobApplicationRepository;

@Service
public class JobApplicationService {

	private final JobApplicationRepository repository;
	
	@Autowired
	public JobApplicationService(JobApplicationRepository repository) {
		this.repository = repository;
	}
	
	public void create(JobApplicationDto dto) {
		
		JobApplicationEntity entity = new JobApplicationEntity();
		CardJobEntity cardJobEntity = new CardJobEntity();
		UserEntity userEntity = new UserEntity();
		
		userEntity.setId(dto.getUser().getId());
		cardJobEntity.setId(dto.getCardJob().getId());
		entity.setId(dto.getId());

		entity.setUser(userEntity);
		entity.setCardJob(cardJobEntity);
		entity.setEstimatedTime(dto.getEstimatedTime());
		entity.setApplicationDate(dto.getApplicationDate());
		
		repository.save(entity);
	}
	
	public void update() {}
	
	public List<JobApplicationEntity> getAllJobApplications() {
		return repository.findAll();
	}
	
	
}
