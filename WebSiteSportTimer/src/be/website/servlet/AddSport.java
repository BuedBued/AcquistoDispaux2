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

@WebServlet("/AddSport")
public class AddSport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddSport() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/addsport.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameSport = (String)request.getAttribute("nameSport");
		ArrayList<BSport> listSport = DAOFactory.get().getDAOSport().selectAll();
		
		boolean exist = false;
		int i = 0;
		do {
			if(nameSport.equals(listSport.get(i).getName())) {
				exist = true;
			}
			i++;
		}
		while(!exist && i<listSport.size());
		if(!exist) {
			BSport sport = new BSport();
			sport.setName(nameSport);
			if(DAOFactory.get().getDAOSport().create(sport))
				this.getServletContext().getRequestDispatcher("/sport").forward(request, response);
			else
				doGet(request,response);
		}
		else
			doGet(request,response);
	}

}
