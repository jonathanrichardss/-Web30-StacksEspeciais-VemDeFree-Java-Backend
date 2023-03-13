package com.vemde.free.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vemde.free.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
	
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email and u.password = :password ")
	UserEntity findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	Optional<UserEntity> findByEmail(String email);
}
