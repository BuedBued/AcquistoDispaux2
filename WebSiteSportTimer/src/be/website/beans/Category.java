package be.website.beans;

import java.io.Serializable;

public class Category implements Serializable{
	private static final long serialVersionUID = -6474232469497535388L;
	private int id;
	private String nom;
	private Sport sport;
	
	public Category() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
}
