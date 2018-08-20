package be.website.dao;

import com.sun.jersey.api.client.WebResource;

import be.website.beans.*;
import be.website.linkToAPI.LinkToAPI;

public class DAOFactory extends AbstractDAOFactory {
	protected static final WebResource webResource = LinkToAPI.accessToAPI();
	
	public DAO<BCategory> getDAOCategory() {
		return new DAO_Category(webResource);
	}
	public DAO<BRecord> getDAORecord() {
		return new DAO_Record(webResource);
	}
	public DAO<BSport> getDAOSport() {
		return new DAO_Sport(webResource);
	}
	public DAO<BUser> getDAOUser() {
		return new DAO_User(webResource);
	}
}
