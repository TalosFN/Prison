package com.prison.DTO;
import lombok.Data;

import java.util.List;

import com.prison.entity.CellEntity;
import com.prison.DTO.PrisonerDTO;





@Data
public class CellDTO {
	private Long id;
	private Long cntPrisoners;
	private String kindOfCell;
	private Long cellSize;
	private List<PrisonerDTO> prisoners;
	
	public CellDTO(Long id, Long cntPrisoners, String kindOfCell, List<PrisonerDTO> prisoners, Long cellSize) {
		
		this.id = id;
        this.cntPrisoners = cntPrisoners;
        this.kindOfCell = kindOfCell;
        this.prisoners = prisoners;
        this.cellSize = cellSize;
	}
	public static CellDTO toCellDTO(CellEntity cell) {
		return new CellDTO(cell.getId(), cell.getCntPrisoners(), cell.getKindOfCell(), cell.getPrisoners().stream().map(PrisonerDTO::toPrisonerDTO).toList(), cell.getCellSize());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCntPrisoners() {
		return cntPrisoners;
	}
	public void setCntPrisoners(Long cntPrisoners) {
		this.cntPrisoners = cntPrisoners;
	}
	public List<PrisonerDTO> getPrisoners() {
		return prisoners;
	}
	
	public void setPrisoners(List<PrisonerDTO> prisoners) {
		this.prisoners = prisoners;
	}
	public String getKindOfCell() {
		return kindOfCell;
	}
	public void setKindOfCell(String kindOfCell) {
		this.kindOfCell = kindOfCell;
	}
	public Long getCellSize() {
		return cellSize;
	}
	public void setCellSize(Long cellSize) {
		this.cellSize = cellSize;
	}

}
