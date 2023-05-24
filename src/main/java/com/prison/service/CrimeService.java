package com.prison.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prison.entity.CrimeEntity;
import com.prison.repository.CrimeRepository;

import java.util.List;
import java.util.NoSuchElementException;


@Service

public class CrimeService {
	
	private CrimeRepository crimeRepository;
	
	public CrimeService(CrimeRepository crimeRepository) {
		this.setCrimeRepository(crimeRepository);
	}

	public CrimeRepository getCrimeRepository() {
		return crimeRepository;
	}

	public void setCrimeRepository(CrimeRepository crimeRepository) {
		this.crimeRepository = crimeRepository;
	}

	
	

}
