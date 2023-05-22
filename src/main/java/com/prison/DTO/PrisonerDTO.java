package com.prison.DTO;

import com.prison.entity.CellEntity;
import com.prison.entity.CrimeEntity;
import com.prison.entity.PrisonerEntity;

public class PrisonerDTO {
	
	private Long id;
	private String name;
	private Long termOfImprisonment;
	private CrimeEntity crime; 
	private CellEntity cell;
	
	public PrisonerDTO(Long id, String name, Long termOfImprisonment,CrimeEntity crime, CellEntity cell) {
		
		this.setId(id);
        this.setName(name);
        this.setTermOfImprisonment(termOfImprisonment);
        this.setCrime(crime);
        this.setCell(cell);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTermOfImprisonment() {
		return termOfImprisonment;
	}

	public void setTermOfImprisonment(Long termOfImprisonment) {
		this.termOfImprisonment = termOfImprisonment;
	}

	public CrimeEntity getCrime() {
		return crime;
	}

	public void setCrime(CrimeEntity crime) {
		this.crime = crime;
	}

	public CellEntity getCell() {
		return cell;
	}

	public void setCell(CellEntity cell) {
		this.cell = cell;
	}
	
	public static PrisonerDTO toPrisonerDTO(PrisonerEntity prisoner) {
		return new PrisonerDTO (prisoner.getId(),prisoner.getName(), prisoner.getTermOfImprisonment(), prisoner.getCrime(), prisoner.getCell());
	}
	
	

}
