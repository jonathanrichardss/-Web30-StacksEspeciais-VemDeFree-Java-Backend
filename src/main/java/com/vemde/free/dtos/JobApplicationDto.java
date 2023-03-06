package com.vemde.free.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDto {
	

	private UUID id;	
	private UserDto user;
	private CardJobDto cardJob;
	private LocalDateTime applicationDate;
	private String estimatedTime;

}
