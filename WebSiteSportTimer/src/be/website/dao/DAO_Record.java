package be.website.dao;

import com.sun.jersey.api.client.WebResource;

import be.website.beans.BRecord;

public class DAO_Record extends DAO<BRecord> {
	public DAO_Record(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(BRecord obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BRecord obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BRecord obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BRecord select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
