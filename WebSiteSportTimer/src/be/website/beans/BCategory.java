package be.website.beans;

import java.io.Serializable;

public class BCategory implements Serializable{
	private static final long serialVersionUID = -6474232469497535388L;
	private int id;
	private String name;
	private BSport sport;
	
	public BCategory() {}

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
	public BSport getSport() {
		return sport;
	}
	public void setSport(BSport sport) {
		this.sport = sport;
	}
	
}
