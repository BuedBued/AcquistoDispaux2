package be.website.xmlTraslate;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

import org.w3c.dom.CharacterData;

import be.website.beans.BSport;

public class XMLTranslate {
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
