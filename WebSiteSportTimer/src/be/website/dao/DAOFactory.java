package be.website.dao;

import com.sun.jersey.api.client.WebResource;

import be.website.beans.Category;
import be.website.beans.Record;
import be.website.beans.Sport;
import be.website.beans.User;
import be.website.linkToAPI.LinkToAPI;

public class DAOFactory extends AbstractDAOFactory {
	protected static final WebResource webResource = LinkToAPI.accessToAPI();
	
	public DAO<Category> getDAOCategory() {
		return new DAO_Category(webResource);
	}
	public DAO<Record> getDAORecord() {
		return new DAO_Record(webResource);
	}
	public DAO<Sport> getDAOSport() {
		return new DAO_Sport(webResource);
	}
	public DAO<User> getDAOUser() {
		return new DAO_User(webResource);
	}
}
