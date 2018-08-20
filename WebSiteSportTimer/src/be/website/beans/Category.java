package be.website.beans;

import java.io.Serializable;

public class Category implements Serializable{
	private static final long serialVersionUID = -6474232469497535388L;
	private int id;
	private String name;
	private Sport sport;
	
	public Category() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
}
