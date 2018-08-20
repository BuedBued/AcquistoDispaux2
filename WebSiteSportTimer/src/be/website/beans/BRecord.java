package be.website.beans;

import java.io.Serializable;

public class BRecord implements Serializable{
	private static final long serialVersionUID = -4257203735548628947L;
	private int id;
	private double time;
	private BCategory category;
	private BUser user;
	
	public BRecord() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public BCategory getCategory() {
		return category;
	}
	public void setCategory(BCategory category) {
		this.category = category;
	}
	public BUser getUser() {
		return user;
	}
	public void setUser(BUser user) {
		this.user = user;
	}
	
}
