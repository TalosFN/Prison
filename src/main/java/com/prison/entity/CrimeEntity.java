package com.prison.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "crimes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CrimeEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String article; //Статья уголовного кодекса
    private String date ; //Дата преступления
    @OneToOne
    private PrisonerEntity prisoner;
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
	public Long getID() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PrisonerEntity getPrisoner() {
		return prisoner;
	}
	public void setPrisoner (PrisonerEntity prisoner) {
		this.prisoner = prisoner;
	}
	public CrimeEntity(Long id, String article, String date, PrisonerEntity prisoner)
	{
		this.id = id;
		this.article = article;
		this.date = date;
		this.prisoner = prisoner;
		
	}
     

}
