package be.website.dao;

import be.website.beans.Category;
import be.website.beans.Record;
import be.website.beans.Sport;
import be.website.beans.User;

public abstract class AbstractDAOFactory {
	public static AbstractDAOFactory get(){
		return new DAOFactory();
	}
	
	public abstract DAO<Category> getDAOCategory();
	public abstract DAO<Record> getDAORecord();
	public abstract DAO<Sport> getDAOSport();
	public abstract DAO<User> getDAOUser();
}
