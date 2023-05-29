package com.prison.DTO;

import com.prison.entity.CrimeEntity;
import com.prison.entity.PrisonerEntity;

public class CrimeDTO {
	
	private Long id;
	private String article;
	private String date;
	private PrisonerEntity prisoner;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public PrisonerEntity getPrisoner() {
		return prisoner;
	}
	public void setPrisoner(PrisonerEntity prisoner) {
		this.prisoner = prisoner;
	}
	
	public CrimeDTO (Long id, String article, String date, PrisonerEntity prisoner)
	{
		this.id = id;
		this.article = article;
		this.date = date;
		this.prisoner = prisoner;
		
	}
	public static CrimeDTO toCrimeDTO(CrimeEntity crime) {
		
		return new CrimeDTO(crime.getID(), crime.getArticle(), crime.getDate(), crime.getPrisoner());
	}
	
	
	

}
