package be.website.XMLTranslate;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

import org.w3c.dom.CharacterData;

import be.website.beans.BCategory;
import be.website.beans.BSport;
import be.website.beans.BUser;
import be.website.dao.DAOFactory;

public class XMLTranslate {
	
	//Extraction d'un sport en XML
	public static BSport getSportFromXML(Document xml) {
		BSport res = null;
		NodeList sportN = xml.getElementsByTagName("sport");
		Element sportE = (Element)sportN.item(0);
		
		NodeList idSportN = sportE.getElementsByTagName("id");
		Element value = (Element)idSportN.item(0);
		String id = getValueFromElement(value);
		
		NodeList nameSportN = sportE.getElementsByTagName("name");
		value = (Element)nameSportN.item(0);
		String name = getValueFromElement(value);
		
		if(id!=null && name!=null) {
			res = new BSport();
			res.setId(Integer.parseInt(id));
			res.setName(name);
		}
		return res;
	}
	
	//Exctraction d'une liste de sports dans le XML
	public static ArrayList<BSport> getAllSportsFromXML(Document xml){
		ArrayList<BSport> listSports = new ArrayList<BSport>();
		BSport res;
		
		NodeList listSportsN = xml.getElementsByTagName("sports");
		Element listSportsE = (Element)listSportsN.item(0);
		
		NodeList sportN = listSportsE.getElementsByTagName("sport");
		for(int i = 0; i<sportN.getLength(); i++) {
			Element sportE = (Element)sportN.item(i);
			
			NodeList idSportN = sportE.getElementsByTagName("id");
			Element value = (Element)idSportN.item(0);
			String id = getValueFromElement(value);
			
			NodeList nameSportN = sportE.getElementsByTagName("name");
			value = (Element)nameSportN.item(0);
			String name = getValueFromElement(value);
			
			if(id!=null && name!=null) {
				res = new BSport();
				res.setId(Integer.parseInt(id));
				res.setName(name);
				listSports.add(res);
			}
		}
		return listSports;
	}
	
	//Extraction d'un utilisateur
	public static BUser getUserFromXML(Document xml) {
		BUser res = null;
		NodeList userN = xml.getElementsByTagName("user");
		Element userE = (Element)userN.item(0);
		
		NodeList idUserN = userE.getElementsByTagName("id");
		Element value = (Element)idUserN.item(0);
		String id = getValueFromElement(value);
		
		NodeList loginN = userE.getElementsByTagName("login");
		value = (Element)loginN.item(0);
		String login = getValueFromElement(value);
		
		NodeList passwordN = userE.getElementsByTagName("password");
		value = (Element)passwordN.item(0);
		String password = getValueFromElement(value);
		
		NodeList firstNameN = userE.getElementsByTagName("firstName");
		value = (Element)firstNameN.item(0);
		String firstName = getValueFromElement(value);
		
		NodeList lastNameN = userE.getElementsByTagName("lastName");
		value = (Element)lastNameN.item(0);
		String lastName = getValueFromElement(value);
		
		if(id!=null && login!=null && password!=null && firstName!=null && lastName!=null) {
			res = new BUser();
			res.setId(Integer.parseInt(id));
			res.setLogin(login);
			res.setPassword(password);
			res.setFirstName(firstName);
			res.setLastName(lastName);
		}
		return res;
	}
	
	//Extraction d'une liste d'utilisateurs
	public static ArrayList<BUser> getAllUsersFromXML(Document xml){
		ArrayList<BUser> listUsers = new ArrayList<BUser>();
		BUser res;
		
		NodeList listUsersN = xml.getElementsByTagName("users");
		Element listUsersE = (Element)listUsersN.item(0);
		
		NodeList userN = listUsersE.getElementsByTagName("user");
		for(int i = 0; i<userN.getLength(); i++) {
			Element userE = (Element)userN.item(i);
			
			NodeList idUserN = userE.getElementsByTagName("id");
			Element value = (Element)idUserN.item(0);
			String id = getValueFromElement(value);
			
			NodeList loginN = userE.getElementsByTagName("login");
			value = (Element)loginN.item(0);
			String login = getValueFromElement(value);
			
			NodeList passwordN = userE.getElementsByTagName("password");
			value = (Element)passwordN.item(0);
			String password = getValueFromElement(value);
			
			NodeList firstNameN = userE.getElementsByTagName("firstName");
			value = (Element)firstNameN.item(0);
			String firstName = getValueFromElement(value);
			
			NodeList lastNameN = userE.getElementsByTagName("lastName");
			value = (Element)lastNameN.item(0);
			String lastName = getValueFromElement(value);
			
			if(id!=null && login!=null && password!=null && firstName!=null && lastName!=null) {
				res = new BUser();
				res.setId(Integer.parseInt(id));
				res.setLogin(login);
				res.setPassword(password);
				res.setFirstName(firstName);
				res.setLastName(lastName);
				listUsers.add(res);
			}
		}
		return listUsers;
	}
	
	//Extraction d'une catégorie
	public static BCategory getCategoryFromXML(Document xml) {
		BCategory res = null;
		NodeList categoryN = xml.getElementsByTagName("user");
		Element categoryE = (Element)categoryN.item(0);
		
		NodeList idCategoryN = categoryE.getElementsByTagName("id");
		Element value = (Element)idCategoryN.item(0);
		String id = getValueFromElement(value);
		
		NodeList nameN = categoryE.getElementsByTagName("name");
		value = (Element)nameN.item(0);
		String name = getValueFromElement(value);
		
		NodeList idSportN = categoryE.getElementsByTagName("idSport");
		value = (Element)idSportN.item(0);
		String idSportString = getValueFromElement(value);
		
		if(id!=null && name!=null && idSportString!=null) {
			res = new BCategory();
			res.setId(Integer.parseInt(id));
			res.setName(name);
			int idSport = Integer.parseInt(idSportString);
			res.setSport(DAOFactory.get().getDAOSport().select(idSport));
		}
		return res;
	}
	
	public static ArrayList<BCategory> getAllCategoriesFromXML(Document xml){
		ArrayList<BCategory> listCategories = new ArrayList<BCategory>();
		BCategory res;
		
		NodeList listCategoriesN = xml.getElementsByTagName("categories");
		Element listCategoriesE = (Element)listCategoriesN.item(0);
		
		NodeList categoryN = listCategoriesE.getElementsByTagName("category");
		for(int i = 0; i<categoryN.getLength(); i++) {
			Element categoryE = (Element)categoryN.item(i);
			
			NodeList idCategoryN = categoryE.getElementsByTagName("id");
			Element value = (Element)idCategoryN.item(0);
			String id = getValueFromElement(value);
			
			NodeList nameN = categoryE.getElementsByTagName("name");
			value = (Element)nameN.item(0);
			String name = getValueFromElement(value);
			
			NodeList idSportN = categoryE.getElementsByTagName("idSport");
			value = (Element)idSportN.item(0);
			String idSportString = getValueFromElement(value);
			
			if(id!=null && name!=null && idSportString!=null) {
				res = new BCategory();
				res.setId(Integer.parseInt(id));
				res.setName(name);
				int idSport = Integer.parseInt(idSportString);
				res.setSport(DAOFactory.get().getDAOSport().select(idSport));
				listCategories.add(res);
			}
		}
		return listCategories;
	}
	
	//Récupération de la valeur d'une balise XML
	public static String getValueFromElement(Element e) {
		String dataS = null;
		try {
			CharacterData data = (CharacterData)e.getFirstChild();
			dataS = data.getData();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return dataS;
	}

}
