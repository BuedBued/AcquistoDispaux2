package be.website.dao;
import com.sun.jersey.api.client.WebResource;

import be.website.beans.BUser;

public class DAO_User extends DAO<BUser> {
	public DAO_User(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(BUser obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BUser obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BUser obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BUser select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
