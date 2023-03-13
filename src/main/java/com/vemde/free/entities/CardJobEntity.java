package com.vemde.free.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_card_job")
public class CardJobEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "required_experience")
	private String requiredExperience;
	
	@Column(name = "company")
	private String companyName;
	
	@Column(name = "date_of_issue")
	private LocalDate issueDate;
	
	@Column(name = "time_job" )
	private LocalDate timeJob;
	
	@Column(name = "payment_value", nullable = false)
	private BigDecimal paymentValue;
	
}
