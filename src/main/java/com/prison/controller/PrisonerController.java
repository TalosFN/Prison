package com.prison.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prison.DTO.CellDTO;
import com.prison.DTO.PrisonerDTO;
import com.prison.entity.PrisonerEntity;
import com.prison.service.PrisonerService;


import java.util.List;

@RestController
@RequestMapping("/prisoner")
public class PrisonerController {
	private final PrisonerService prisonerService;
	
	public PrisonerController(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
    }
	
	@GetMapping("/")
    public ResponseEntity<List<PrisonerDTO>> customers() {
        return ResponseEntity.ok().body(prisonerService.prisoners());
    }
	
	@GetMapping("/{cellId}/prisoner")
    public ResponseEntity<List<PrisonerDTO>> getPrisonersByCellId(@PathVariable Long cellId) {
        return prisonerService.getPrisonersByCellId(cellId);
    }
	
	@PostMapping("/{cellId}/{prisonerId}")
    public ResponseEntity<CellDTO> addPrisonerToCellByCellId(@PathVariable Long cellId, @PathVariable Long prisonerId) {
        return prisonerService.addPrisonerToCellByCellId(cellId, prisonerId);
    }
	@PatchMapping("/{prisonerId}")
    public ResponseEntity<PrisonerDTO> updatePrisoner(@RequestBody PrisonerEntity prisoner, @PathVariable Long prisonerId) {
        return prisonerService.updatePrisoner(prisoner, prisonerId);
    }
	@DeleteMapping("/{prisonerId}")
    public ResponseEntity<PrisonerDTO> removePrisoner(@PathVariable Long prisonerId) {
        return prisonerService.removePrisoner(prisonerId);
	}

}
