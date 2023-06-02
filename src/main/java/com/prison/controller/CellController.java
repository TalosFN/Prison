package com.prison.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prison.DTO.CellDTO;
import com.prison.entity.CellEntity;
import com.prison.service.CellService;


import java.util.List;

@RestController
@RequestMapping("/cell")
public class CellController {
	private final CellService cellService;
	
	
	public CellController(CellService cellService) {
		this.cellService = cellService;
	}
	@GetMapping("/")
	public ResponseEntity<List<CellDTO>> cells() {
        return ResponseEntity.ok().body(cellService.cells());
    }
	@PostMapping("/")
    public ResponseEntity<CellDTO> addCell(@RequestBody CellEntity cell) {
        return ResponseEntity.ok().body(cellService.addCell(cell));
    }
	
	@GetMapping("/{cellId}")
    public ResponseEntity<CellDTO> cell(@PathVariable Long cellId) {
        return cellService.cell(cellId);
    }
	@PatchMapping("/{cellId}")
    public ResponseEntity<CellDTO> updateCell(@RequestBody CellEntity cell, @PathVariable Long cellId) {
        return cellService.updateCell(cell, cellId);
    }
	@DeleteMapping("/{cellId}")
    public ResponseEntity<CellDTO> removeCell(@PathVariable Long cellId, Long secCellId) {
        return cellService.removeCell(cellId, secCellId);
        
    }
	
	
	

}
