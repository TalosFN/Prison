package com.prison.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prison.repository.CrimeRepository;
import com.prison.repository.PrisonerRepository;

import java.util.List;
import java.util.NoSuchElementException;


@Service

public class PrisonerService {
	
	private PrisonerRepository prisonerRepository;
	private CrimeRepository crimeRepository;
	
	public PrisonerService(PrisonerRepository prisonerRepository,CrimeRepository crimeRepository) {
		this.prisonerRepository = prisonerRepository;
		this.crimeRepository = crimeRepository;
		
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
	

}
