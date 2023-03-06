package com.vemde.free.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vemde.free.entities.CardJobEntity;

@Repository
public interface JobCardRepository extends JpaRepository<CardJobEntity, UUID>{
	
}
