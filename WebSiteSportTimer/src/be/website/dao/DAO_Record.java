package be.website.dao;

import com.sun.jersey.api.client.WebResource;

import be.website.beans.Record;

public class DAO_Record extends DAO<Record> {
	public DAO_Record(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(Record obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Record obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Record obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Record select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
