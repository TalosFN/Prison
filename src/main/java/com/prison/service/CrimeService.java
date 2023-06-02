package com.prison.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prison.DTO.CellDTO;
import com.prison.DTO.CrimeDTO;
import com.prison.entity.CellEntity;
import com.prison.entity.CrimeEntity;
import com.prison.entity.PrisonerEntity;
import com.prison.repository.CellRepository;
import com.prison.repository.CrimeRepository;
import com.prison.repository.PrisonerRepository;


import java.util.List;
import java.util.NoSuchElementException;


@Service

public class CrimeService {
	
	private final CrimeRepository crimeRepository;
	private final PrisonerRepository prisonerRepository;
	private final CellRepository cellRepository;
	
	public CrimeService(CrimeRepository crimeRepository, PrisonerRepository prisonerRepository, CellRepository cellRepository) {
        this.crimeRepository = crimeRepository;
        this.prisonerRepository = prisonerRepository;
        this.cellRepository = cellRepository;
    }
	
	 
	 public ResponseEntity<CrimeDTO> crime(Long id) {
	        try {
	            return ResponseEntity.ok().body(CrimeDTO.toCrimeDTO(crimeRepository.findById(id).orElseThrow()));
	        } catch (NoSuchElementException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	 public ResponseEntity<CrimeEntity> getCrimeByPrisonerId(Long prisonerId) {
	        try {
	            return ResponseEntity.ok().body(crimeRepository.findById(prisonerId).orElseThrow());
	        } catch (NoSuchElementException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	 public CrimeDTO addCrime(CrimeEntity crime) {
	        return CrimeDTO.toCrimeDTO(crimeRepository.save(crime));
	    }
	 

	public ResponseEntity<CrimeDTO> updateCrime(CrimeEntity changedCrime, Long id) {
        try {
            CrimeEntity crime = crimeRepository.findById(id).orElseThrow();
            
            if(changedCrime.getArticle() != null) {
                crime.setArticle(changedCrime.getArticle());                
            }
            if(changedCrime.getDate() != null) {
                crime.setArticle(changedCrime.getDate());                    
            }            
            return ResponseEntity.ok().body(CrimeDTO.toCrimeDTO(crime));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
	}
        
        public ResponseEntity<CrimeDTO> deleteCrime(Long remId) {
            try {
                CrimeEntity crime = crimeRepository.findById(remId).orElseThrow();
                prisonerRepository.delete(crime.getPrisoner());
                crimeRepository.delete(crime);
                

                return ResponseEntity.ok().body(CrimeDTO.toCrimeDTO(crime));
            } catch (NoSuchElementException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        }
    }
	
	


	    

	
	


