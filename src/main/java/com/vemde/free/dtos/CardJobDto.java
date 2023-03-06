package com.vemde.free.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardJobDto {

	private UUID id;
	private String title;
	private String description;
	private String requiredExperience;
	private LocalDate issueDate;
	private LocalDate timeJob;
	private BigDecimal paymentValue;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
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
	public BigDecimal getPaymentValue() {
		return paymentValue;
	}
	public void setPaymentValue(BigDecimal paymentValue) {
		this.paymentValue = paymentValue;
	}
	
	
}
