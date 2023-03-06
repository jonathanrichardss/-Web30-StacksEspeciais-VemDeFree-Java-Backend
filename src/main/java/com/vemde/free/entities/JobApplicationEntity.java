package com.vemde.free.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_job_application")
public class JobApplicationEntity {

	
	@Id
	@Column(name = "id", unique = true)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne
	@JoinColumn(name = "card_job_id")
	private CardJobEntity cardJob;
	
	@Column(name = "application_date")
	private LocalDateTime applicationDate;
	
	@Column(name = "estimated_time")
	private String estimatedTime;

	
}
