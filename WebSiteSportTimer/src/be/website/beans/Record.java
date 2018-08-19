package be.website.beans;

import java.io.Serializable;

public class Record implements Serializable{
	private static final long serialVersionUID = -4257203735548628947L;
	private int id;
	private double time;
	private Category category;
	private User user;
	
	public Record() {}

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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
