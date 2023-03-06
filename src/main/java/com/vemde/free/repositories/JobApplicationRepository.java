package com.vemde.free.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vemde.free.entities.JobApplicationEntity;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplicationEntity, UUID> {

}
