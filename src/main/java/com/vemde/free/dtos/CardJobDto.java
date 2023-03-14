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
	private String companyName;
	private String city;
	private LocalDate issueDate;
	private LocalDate timeJob;
	private BigDecimal paymentValue;
	
}
