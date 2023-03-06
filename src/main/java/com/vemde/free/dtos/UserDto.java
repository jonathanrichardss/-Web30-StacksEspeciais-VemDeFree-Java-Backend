package com.vemde.free.dtos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private UUID id;
	private String name;
	private String password;
	private String nrCpfCnpj;
	private String gender;
	private Date birthYear;
	private String address;
	private String email;
	private String idProfile;
	private Boolean isActive;
	private List<JobApplicationDto> applications;
	
}
