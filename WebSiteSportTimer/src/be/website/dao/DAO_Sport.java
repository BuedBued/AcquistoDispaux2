package be.website.dao;


import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import java.io.StringReader;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import be.website.beans.BSport;
import be.website.xmlTraslate.XMLTranslate;

public class DAO_Sport extends DAO<BSport> {
	public DAO_Sport(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(BSport obj) {
		boolean b = false;
		int id = -1;
		try {
			
			ClientResponse response = webResource.path("sport").queryParam("name",obj.getName()).accept(MediaType.TEXT_PLAIN).post(ClientResponse.class);
			id = response.getEntity(int.class);
			if(id>0) {
				obj.setId(id);
				b = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete(BSport obj) {
		boolean b = false;
		try {
			ClientResponse response = webResource.path("sport/"+obj.getId()).delete(ClientResponse.class);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean update(BSport obj) {
		boolean b = false;
		try {
			MultivaluedMap<String,String> params = new MultivaluedMapImpl();
			params.add("id", Integer.toString(obj.getId()));
			params.add("name", obj.getName());
			
			ClientResponse response = webResource.path("sport").type("application/x-www-form-urlencoded").put(ClientResponse.class, params);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public BSport select(int id){
		BSport res = null;
		String xmlString = webResource.path("sport/"+id).accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			res = XMLTranslate.getSportFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<BSport> selectAll(){
		ArrayList<BSport> listSport = new ArrayList<BSport>();
		String xmlString = webResource.path("sport").accept(MediaType.TEXT_XML).get(String.class);
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			listSport = XMLTranslate.getAllSportsFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listSport;
	}
}
