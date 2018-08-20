package be.website.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.website.beans.BSport;
import be.website.dao.DAOFactory;
import be.website.dao.DAO_Sport;

@WebServlet("/Sport")
public class Sport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sport() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO_Sport daoS = (DAO_Sport)DAOFactory.get().getDAOSport();
		ArrayList<BSport> listSport = daoS.selectAll();
		request.setAttribute("listSport", listSport);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/sport.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
