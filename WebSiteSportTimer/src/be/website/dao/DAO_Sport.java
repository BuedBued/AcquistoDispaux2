package be.website.dao;


import com.sun.jersey.api.client.WebResource;

import be.website.beans.Sport;

public class DAO_Sport extends DAO<Sport> {
	public DAO_Sport(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sport select(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
