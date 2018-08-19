package be.website.beans;

import java.io.Serializable;

public class Sport implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	
	public Sport() {}

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
}
