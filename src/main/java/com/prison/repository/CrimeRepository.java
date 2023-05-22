package com.prison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prison.entity.CrimeEntity;



import java.util.Optional;

@Repository
public interface CrimeRepository extends JpaRepository<CrimeEntity, Long>{
	
	@Override
    Optional<CrimeEntity> findById(Long id);

}
