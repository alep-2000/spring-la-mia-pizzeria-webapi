package org.java.spring.db.pojo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OffertaSpeciale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date dataInizio;
	private Date dataFine;
	private String titolo;
	
	public OffertaSpeciale() {}
	public OffertaSpeciale(Date dataInizio, Date dataFine, String titolo) {
		setDataInizio(dataInizio);
		setDataFine(dataFine);
		setTitolo(titolo);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Override
	public String toString() {
		return getId() + "/n"
				+ getDataInizio() 
				+ getDataFine()
				+ getTitolo();
	}
}
