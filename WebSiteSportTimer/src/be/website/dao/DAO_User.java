package be.website.dao;
import java.io.StringReader;
import java.math.BigDecimal;
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

import be.website.beans.BUser;
import be.website.XMLTranslate.XMLTranslate;

public class DAO_User extends DAO<BUser> {
	public DAO_User(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(BUser obj) {
		boolean b = false;
		int id = -1;
		try {
			MultivaluedMap<String,String> params = new MultivaluedMapImpl();
			params.add("login",obj.getLogin());
			params.add("password",obj.getPassword());
			params.add("firstName",obj.getFirstName());
			params.add("lastName",obj.getLastName());
			ClientResponse response = webResource.path("user").type("application/x-www-form-urlencoded").post(ClientResponse.class, params);
			id = Integer.parseInt(response.getEntity(String.class));
			if(id>0) {
				obj.setId(id);
				if(response.getStatus()==200)
					b = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean delete(BUser obj) {
		boolean b = false;
		try {
			ClientResponse response = webResource.path("user/"+obj.getId()).delete(ClientResponse.class);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean update(BUser obj) {
		boolean b = false;
		try {
			MultivaluedMap<String,String> params = new MultivaluedMapImpl();
			params.add("id",Integer.toString(obj.getId()));
			params.add("login",obj.getLogin());
			params.add("password",obj.getPassword());
			params.add("firstName",obj.getFirstName());
			params.add("lastName",obj.getLastName());
			
			ClientResponse response = webResource.path("user").type("application/x-www-form-urlencoded").put(ClientResponse.class, params);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public BUser select(int id) {
		BUser res = null;
		String xmlString = webResource.path("user/"+id).accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			res = XMLTranslate.getUserFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public ArrayList<BUser> selectAll(){
		ArrayList<BUser> listUser = new ArrayList<BUser>();
		String xmlString = webResource.path("user").accept(MediaType.TEXT_XML).get(String.class);
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			listUser = XMLTranslate.getAllUsersFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}
}
