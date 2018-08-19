package be.website.dao;
import com.sun.jersey.api.client.WebResource;

import be.website.beans.User;

public class DAO_User extends DAO<User> {
	public DAO_User(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
