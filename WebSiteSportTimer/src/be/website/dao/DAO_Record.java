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
import be.website.beans.BRecord;

public class DAO_Record extends DAO<BRecord> {
	public DAO_Record(WebResource webResource) {
		super(webResource);
	}

	@Override
	public boolean create(BRecord obj) {
		boolean b = false;
		int id = -1;
		try {
			MultivaluedMap<String,String> params = new MultivaluedMapImpl();
			params.add("timer",Double.toString(obj.getTime()));
			params.add("idCategory",Integer.toString(obj.getCategory().getId()));
			params.add("idUser",Integer.toString(obj.getUser().getId()));
			ClientResponse response = webResource.path("record").type("application/x-www-form-urlencoded").post(ClientResponse.class, params);
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
	public boolean delete(BRecord obj) {
		boolean b = false;
		try {
			ClientResponse response = webResource.path("record/"+obj.getId()).delete(ClientResponse.class);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean update(BRecord obj) {
		boolean b = false;
		try {
			MultivaluedMap<String,String> params = new MultivaluedMapImpl();
			params.add("id",Integer.toString(obj.getId()));
			params.add("timer",Double.toString(obj.getTime()));
			params.add("idCategory",Integer.toString(obj.getCategory().getId()));
			params.add("idUser",Integer.toString(obj.getUser().getId()));
			
			ClientResponse response = webResource.path("record").type("application/x-www-form-urlencoded").put(ClientResponse.class, params);
			if(response.getStatus()==200)
				b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public BRecord select(int id) {
		BRecord res = null;
		String xmlString = webResource.path("record/"+id).accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			res = XMLTranslate.getRecordFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public ArrayList<BRecord> selectAll(){
		ArrayList<BRecord> listRecord = new ArrayList<BRecord>();
		String xmlString = webResource.path("user").accept(MediaType.TEXT_XML).get(String.class);
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			Document doc = db.parse(is);
			listRecord = XMLTranslate.getAllRecordsFromXML(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listRecord;
	}

}
