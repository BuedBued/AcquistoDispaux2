package be.website.dao;

import com.sun.jersey.api.client.WebResource;

import be.website.beans.BCategory;

public class DAO_Category extends DAO<BCategory> {
	public DAO_Category(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(BCategory obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BCategory obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BCategory obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BCategory select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
