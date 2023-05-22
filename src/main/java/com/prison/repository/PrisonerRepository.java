package com.prison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prison.entity.PrisonerEntity;


import java.util.Optional;

@Repository
public interface PrisonerRepository extends JpaRepository<PrisonerEntity, Long>{
	
	@Override
    Optional<PrisonerEntity> findById(Long id);

}
