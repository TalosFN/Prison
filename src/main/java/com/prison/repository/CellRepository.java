package com.prison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prison.entity.CellEntity;


import java.util.Optional;

@Repository
public interface CellRepository extends JpaRepository<CellEntity, Long> {
	@Override
    Optional<CellEntity> findById(Long id);

}
