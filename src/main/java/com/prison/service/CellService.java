package com.prison.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prison.DTO.CellDTO;
import com.prison.DTO.PrisonerDTO;
import com.prison.entity.CellEntity;
import com.prison.entity.PrisonerEntity;
import com.prison.repository.CellRepository;
import com.prison.repository.CrimeRepository;
import com.prison.repository.PrisonerRepository;


import java.util.List;
import java.util.NoSuchElementException;


@Service

public class CellService {

	private  CellRepository cellRepository;
	private  CrimeRepository crimeRepository;
	private  PrisonerRepository prisonerRepository;
	
	
	public CellService (CellRepository cellRepository, CrimeRepository crimeRepository, PrisonerRepository prisonerRepository) {
		this.cellRepository = cellRepository;
		this.crimeRepository = crimeRepository;
		this.prisonerRepository = prisonerRepository;
	}
	public CellRepository getCellRepository() {
		return cellRepository;
	}
	public CrimeRepository getCrimeRepository() {
		return crimeRepository;
	}
	public PrisonerRepository getPrisonerRepository() {
		return prisonerRepository;
	}
	public List<CellDTO> cells() {
        return cellRepository.findAll().stream().map(CellDTO::toCellDTO).toList();
    }
	
	public ResponseEntity<CellDTO> cell(Long id) {
        try {
            return ResponseEntity.ok().body(CellDTO.toCellDTO(cellRepository.findById(id).orElseThrow()));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	public CellDTO addCell(CellEntity cell) {
        return CellDTO.toCellDTO(cellRepository.save(cell));
    }
	public ResponseEntity<List<PrisonerDTO>> getPrisonersByCellId(Long cellId) {
        try {
            return ResponseEntity.ok().body(cellRepository.findById(cellId).orElseThrow().getPrisoners().stream().map(PrisonerDTO::toPrisonerDTO).toList());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	public ResponseEntity<CellDTO> updateCell(CellEntity changedCell, Long id) {
        try {
            CellEntity cell = cellRepository.findById(id).orElseThrow();
            
            if(changedCell.getKindOfCell() != null) {
                cell.setKindOfCell(changedCell.getKindOfCell());
            }
            return ResponseEntity.ok().body(CellDTO.toCellDTO(cell));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	public ResponseEntity<CellDTO> removeCell(Long remId, Long newId) {
        try {
            CellEntity cell = cellRepository.findById(remId).orElseThrow();
            CellEntity newCell = cellRepository.findById(newId).orElseThrow();
            
            List<PrisonerEntity> prisoners = cell.getPrisoners();
            List<PrisonerEntity> newPrisoners = newCell.getPrisoners();
            
            if((newCell.getCellSize() - newCell.getCntPrisoners()) < prisoners.size()) {
            	newPrisoners.addAll(prisoners);            	
            }
            prisoners.forEach(prisoner -> prisoner.setCell(newCell));
            
            cellRepository.delete(cell);

            return ResponseEntity.ok().body(CellDTO.toCellDTO(cell));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
	

    }
	

