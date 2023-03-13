package com.vemde.free.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class UserEntity {

	@Id
	@Column(name = "id", unique = true)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nr_cpf_cnpj")
	private String nrCpfCnpj;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "birth_year")
	private Date birthYear;
	
	@Column(name = "address")
	private String address;		
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "id_profile")
	private String idProfile;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_application_id")
	private List<JobApplicationEntity> applications;
	
}
