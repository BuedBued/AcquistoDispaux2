package be.website.dao;

import com.sun.jersey.api.client.WebResource;

import be.website.beans.Category;

public class DAO_Category extends DAO<Category> {
	public DAO_Category(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
