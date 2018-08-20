package be.website.dao;

import be.website.beans.*;

public abstract class AbstractDAOFactory {
	public static AbstractDAOFactory get(){
		return new DAOFactory();
	}
	
	public abstract DAO<BCategory> getDAOCategory();
	public abstract DAO<BRecord> getDAORecord();
	public abstract DAO<BSport> getDAOSport();
	public abstract DAO<BUser> getDAOUser();
}
