package be.website.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.website.beans.BCategory;
import be.website.beans.BSport;
import be.website.dao.DAOFactory;
import be.website.dao.DAO_Category;
import be.website.dao.DAO_Sport;

@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Category() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		int idCurrentSport = Integer.parseInt(request.getParameter("id"));				
		DAO_Sport daoS = (DAO_Sport)DAOFactory.get().getDAOSport();
		BSport currentSport =  daoS.select(idCurrentSport);
		
		DAO_Category daoC = (DAO_Category)DAOFactory.get().getDAOCategory();
		ArrayList<BCategory> listCat = daoC.selectAll();
		ArrayList<BCategory> listCatSport = new ArrayList<BCategory>();
		
		for(BCategory c : listCat) {
			if(c.getSport().getId() == (idCurrentSport)) {
				listCatSport.add(c);
			}
		}
				
		request.setAttribute("sport", currentSport);
		request.setAttribute("listCat", listCatSport);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
