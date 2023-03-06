package com.vemde.free.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_card_job")
public class CardJobEntity {
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "required_experience")
	private String requiredExperience;
	
	@Column(name = "date_of_issue")
	private LocalDate issueDate;
	
	@Column(name = "time_job" )
	private LocalDate timeJob;
	
//	@Column(name = "payment_value", nullable = false)
//	private Integer paymentValue;

	

	public String getTitle() {
		return title;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getTimeJob() {
		return timeJob;
	}

	public void setTimeJob(LocalDate timeJob) {
		this.timeJob = timeJob;
	}


	
	
}
