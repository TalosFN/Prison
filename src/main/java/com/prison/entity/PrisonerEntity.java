package com.prison.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prisoners")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PrisonerEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String Name;
	private Long TermOfImprisonment;  //Срок заключения
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "crimeEntity") 
    private CrimeEntity crime; 
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn (name="prisoner_id")
	private CellEntity cell;
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		Name = Name;
	}
	public Long getTermOfImprisonment() {
		return TermOfImprisonment;
	}
	public void setTermOfImprisonment(Long termOfImprisonment) {
		TermOfImprisonment = termOfImprisonment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setCell (CellEntity cell) {
		this.cell = cell;
	}
	public PrisonerEntity(Long id, String Name, Long TermOfImprisonment, CrimeEntity crime, CellEntity cell)
	{
		this.id = id;
		this.Name = Name;
		this.TermOfImprisonment = TermOfImprisonment;
		this.crime = crime;
		this.cell = cell;
		
	}
	


}
