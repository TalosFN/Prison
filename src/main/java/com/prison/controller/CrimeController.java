package com.prison.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prison.DTO.CrimeDTO;
import com.prison.entity.CrimeEntity;
import com.prison.service.CrimeService;


import java.util.List;

@RestController
@RequestMapping("/crime")
public class CrimeController {
	private final CrimeService crimeService;
	
	public CrimeController(CrimeService crimeService) {
        this.crimeService = crimeService;
    }
	@GetMapping("/{crimeId}")
    public ResponseEntity<CrimeDTO> crime(@PathVariable Long crimeId) {
        return crimeService.crime(crimeId);
    }
	@PostMapping("/")
    public ResponseEntity<CrimeDTO> addCrime(@RequestBody CrimeEntity crime) {
        return ResponseEntity.ok().body(crimeService.addCrime(crime));
    }
	
	@PatchMapping("/{customerId}")
    public ResponseEntity<CrimeDTO> updateCrime(@RequestBody CrimeEntity crime, @PathVariable Long crimeId) {
        return crimeService.updateCrime(crime, crimeId);
    }
	@DeleteMapping("/{crimeId}")
    public ResponseEntity<CrimeDTO> removeCrime(@PathVariable Long crimeId) {
        return crimeService.deleteCrime(crimeId);
        
    }

}
