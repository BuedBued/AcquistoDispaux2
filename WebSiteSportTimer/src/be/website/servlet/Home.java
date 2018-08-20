package be.website.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.website.beans.BUser;
import be.website.dao.DAOFactory;
import be.website.dao.DAO_User;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/sport.jsp").forward(request, response);
			return;
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		DAO_User daoU = (DAO_User)DAOFactory.get().getDAOUser();
		ArrayList<BUser> listUser = daoU.selectAll();
		
		String login = (String)request.getAttribute("login");
		String pw = (String)request.getAttribute("pw");
		
		for(BUser u : listUser) {
			if(u.getLogin().equals(login)) {
				if(u.getPassword().equals(pw)) {
					session.setAttribute("user", u);
					this.getServletContext().getRequestDispatcher("/WEB-INF/views/sport.jsp").forward(request, response);
					return;
				}
			}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
}
