package com.prison.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prison.DTO.CellDTO;
import com.prison.DTO.CrimeDTO;
import com.prison.DTO.PrisonerDTO;
import com.prison.entity.CellEntity;
import com.prison.entity.CrimeEntity;
import com.prison.entity.PrisonerEntity;
import com.prison.repository.CellRepository;
import com.prison.repository.CrimeRepository;
import com.prison.repository.PrisonerRepository;


import java.util.List;
import java.util.NoSuchElementException;


@Service

public class PrisonerService {
	
	private PrisonerRepository prisonerRepository;
	private CrimeRepository crimeRepository;
	private CellRepository cellRepository;
	
	public PrisonerService(PrisonerRepository prisonerRepository,CrimeRepository crimeRepository, CellRepository cellRepository) {
		this.prisonerRepository = prisonerRepository;
		this.crimeRepository = crimeRepository;
		this.cellRepository = cellRepository;
		
	}
	
	public PrisonerRepository getPrisonerRepository() {
		return prisonerRepository;
	}
	public void setPrisonerRepository(PrisonerRepository prisonerRepository) {
		this.prisonerRepository = prisonerRepository;
	}
	public CrimeRepository getCrimeRepository() {
		return crimeRepository;
	}
	public void setCrimeRepository(CrimeRepository crimeRepository) {
		this.crimeRepository = crimeRepository;
	}
	
	public List<PrisonerDTO> prisoners() {
        return prisonerRepository.findAll().stream().map(PrisonerDTO::toPrisonerDTO).toList();
    }
	
	public ResponseEntity<List<PrisonerDTO>> getPrisonersByCellId(Long cellId) {
        try {
            return ResponseEntity.ok().body(cellRepository.findById(cellId).orElseThrow().getPrisoners().stream().map(PrisonerDTO::toPrisonerDTO).toList());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	public ResponseEntity<CellDTO> addPrisonerToCellByCellId(Long cellId, Long prisonerId) {
        try {
            CellEntity cell = cellRepository.findById(cellId).orElseThrow();
            PrisonerEntity prisoner = prisonerRepository.findById(prisonerId).orElseThrow();

            if(cell.getCellSize() != cell.getCntPrisoners()) {
            	 cell.setCntPrisoners(cell.getCntPrisoners() + 1);
                 cell.getPrisoners().add(prisoner);
                 prisoner.setCell(cell);
                 return ResponseEntity.ok().body(CellDTO.toCellDTO(cellRepository.save(cell)));
            } else {
            	return ResponseEntity.badRequest().build();
            }           
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
	
	
	
	public ResponseEntity<PrisonerDTO> updatePrisoner(PrisonerEntity changedPrisoner, Long prisonerId) {
        try {
            PrisonerEntity prisoner = prisonerRepository.findById(prisonerId).orElseThrow();
            if(changedPrisoner.getName() != null) {
                prisoner.setName(changedPrisoner.getName());
            }
            if(changedPrisoner.getTermOfImprisonment() != null) {
                prisoner.setTermOfImprisonment(changedPrisoner.getTermOfImprisonment());
            }
            
            return ResponseEntity.ok().body(PrisonerDTO.toPrisonerDTO(prisoner));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	public ResponseEntity<PrisonerDTO> removePrisoner(Long prisonerId) {
        try {
            PrisonerEntity prisoner = prisonerRepository.findById(prisonerId).orElseThrow();
            CellEntity cell = prisoner.getCell();
            
            cell.getPrisoners().remove(prisoner);
            cell.setCntPrisoners(cell.getCntPrisoners() - 1);
            prisonerRepository.delete(prisoner);

            return ResponseEntity.ok().body(PrisonerDTO.toPrisonerDTO(prisoner));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	
	
	

}
