package com.prison.entity;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cells")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class CellEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cntPrisoners; //количество заключенных
    private String kindOfCell;
    @OneToMany (mappedBy = "cell", fetch=FetchType.EAGER )//Вид камеры
    private List<PrisonerEntity> prisoners = new ArrayList<>();
	public Long getCntPrisoners() {
		return cntPrisoners;
	}
	public void setCntPrisoners(Long cntPrisoners) {
		this.cntPrisoners = cntPrisoners;
	}
	public String getKindOfCell() {
		return kindOfCell;
	}
	public void setKindOfCell(String kindOfCell) {
		this.kindOfCell = kindOfCell;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<PrisonerEntity> getPrisoners(){
		return prisoners;
	}
	public void setPrisoners(List<PrisonerEntity> prisoners) {
		this.prisoners = prisoners;
	}
	 
	
}


