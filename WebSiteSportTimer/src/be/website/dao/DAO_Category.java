package be.website.dao;

import java.io.StringReader;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.website.XMLTranslate.XMLTranslate;
import be.website.beans.BCategory;

public class DAO_Category extends DAO<BCategory> {
	public DAO_Category(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(BCategory obj) {
		boolean b = false;
		int id = -1;
		try {
			MultivaluedMap<String,String> params = new MultivaluedMapImpl();
			params.add("name",obj.getName());
			params.add("idSport",Integer.toString(obj.getSport().getId()));
			ClientResponse response = webResource.path("category").type("application/x-www-form-urlencoded").post(ClientResponse.class, params);
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
	public boolean delete(BCategory obj) {
		boolean b = false;
		try {
			ClientResponse response = webResource.path("category/"+obj.getId()).delete(ClientResponse.class);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean update(BCategory obj) {
		boolean b = false;
		try {
			MultivaluedMap<String,String> params = new MultivaluedMapImpl();
			params.add("id",Integer.toString(obj.getId()));
			params.add("name",obj.getName());
			params.add("idSport",Integer.toString(obj.getSport().getId()));
			
			ClientResponse response = webResource.path("category").type("application/x-www-form-urlencoded").put(ClientResponse.class, params);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public BCategory select(int id) {
		BCategory res = null;
		String xmlString = webResource.path("category/"+id).accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			res = XMLTranslate.getCategoryFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public ArrayList<BCategory> selectAll(){
		ArrayList<BCategory> listCat = new ArrayList<BCategory>();
		String xmlString = webResource.path("category").accept(MediaType.TEXT_XML).get(String.class);
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			listCat = XMLTranslate.getAllCategoriesFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listCat;
	}

}
