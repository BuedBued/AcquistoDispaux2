package be.webservices.CRUD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.webservices.connexion.DBConnect;
import oracle.jdbc.internal.OracleTypes;

@Path("sport")
public class CRUD_Sport {

	private Connection con = DBConnect.getInstance();
	
	public CRUD_Sport() {}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getAllSports() throws SQLException{
		Response response = null;
		CallableStatement stmt = null;
		ResultSet resultSet = null;
		String xml = "<?xml version=\"1.0\"?>";
		try {
			stmt = con.prepareCall("{ ? = call SPORT_PACKAGE.findall}");
			stmt.registerOutParameter(1,OracleTypes.CURSOR);
			stmt.execute();
			resultSet = (ResultSet)stmt.getObject(1);
			if(resultSet!=null) {
				xml += "<sports>";
				while(resultSet.next()) {
					xml += "<sport>";
					xml += "<id>" + resultSet.getInt("id") + "</id>";
					xml += "<name>" + resultSet.getString("name") + "</name>";
					xml += "</sport>";
				}
				xml += "</sports>";
				response = Response.status(Status.OK).entity(xml).build();
			}
			else
				response = Response.status(500).build();
		}
		catch(SQLException e) {
			System.out.println("SQL ERROR : " + e.getMessage());
			response = Response.status(Status.BAD_REQUEST).build();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			response = Response.status(500).build();
		}
		finally{
			if(resultSet!=null)
				resultSet.close();
			if(stmt!=null) {
				stmt.close();
			}
		}
		return response;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Response getSport(@PathParam("id") int id) throws SQLException{
		Response response = null;
		CallableStatement stmt = null;
		ResultSet resultSet = null;
		String xml = "<?xml version=\"1.0\"?>";
		try {
			stmt = con.prepareCall("{ ? = call SPORT_PACKAGE.find(?)}");
			stmt.registerOutParameter(1,OracleTypes.CURSOR);
			stmt.setInt(2, id);
			stmt.execute();
			resultSet = (ResultSet)stmt.getObject(1);
			if(resultSet.next()) {
				xml += "<sport>";
				xml += "<id>" + resultSet.getInt("id") + "</id>";
				xml += "<name>" + resultSet.getString("name") + "</name>";
				xml += "</sport>";
				response = Response.status(Status.OK).entity(xml).build();
			}
			else
				response = Response.status(500).build();
		}
		catch(SQLException e) {
			System.out.println("SQL ERROR : " + e.getMessage());
			response = Response.status(Status.BAD_REQUEST).build();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			response = Response.status(500).build();
		}
		finally{
			if(resultSet!=null)
				resultSet.close();
			if(stmt!=null) {
				stmt.close();
			}
		}
		return response;
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response insertSport(@FormParam("name") String name) throws SQLException{
		Response response = null;
		CallableStatement stmt = null;
		ResultSet resultSet = null;
		int id = -1;
		try {
			stmt = con.prepareCall("{ ? = call SPORT_PACKAGE.add(?)}");
			stmt.registerOutParameter(1,OracleTypes.NUMBER);
			stmt.setString(2, name);
			stmt.execute();
			id = stmt.getInt(1);
			response = Response.status(Status.OK).entity(id).build();
		}
		catch(SQLException e) {
			System.out.println("SQL ERROR : " + e.getMessage());
			response = Response.status(Status.BAD_REQUEST).build();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			response = Response.status(500).build();
		}
		finally{
			if(resultSet!=null)
				resultSet.close();
			if(stmt!=null) {
				stmt.close();
			}
		}
		return response;
	}
	
	@PUT
	public void updateSport(@FormParam("id") int id,
			@FormParam("name") String name) throws SQLException{
		CallableStatement stmt = null;
		try {
			stmt = con.prepareCall("{ call SPORT_PACKAGE.upd(?,?)}");
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("SQL ERROR : " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			if(stmt!=null) {
				stmt.close();
			}
		}
	}
	
	@DELETE
	@Path("{id}")
	public void deleteSport(@PathParam("id") int id) throws SQLException{
		CallableStatement stmt = null;
		try {
			stmt = con.prepareCall("{ call SPORT_PACKAGE.del(?)}");
			stmt.setInt(1,id);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("SQL ERROR : " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			if(stmt!=null) {
				stmt.close();
			}
		}
	}
}
