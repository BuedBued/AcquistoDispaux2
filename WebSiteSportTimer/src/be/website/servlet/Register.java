package be.website.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.website.beans.BUser;
import be.website.dao.DAOFactory;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String login = request.getParameter("login");
		String pw = request.getParameter("pw");
		
		ArrayList<BUser> listUser = DAOFactory.get().getDAOUser().selectAll();
		
		boolean exist = false;
		int i = 0;
		do {
			if(login.equals(listUser.get(i).getLogin()))
				exist = true;
			i++;
		}
		while(!exist && i<listUser.size());
		
		if(!exist) {
			BUser insert = new BUser();
			insert.setFirstName(fname);
			insert.setLastName(lname);
			insert.setLogin(login);
			insert.setPassword(pw);
			if(DAOFactory.get().getDAOUser().create(insert)) {
				this.getServletContext().getRequestDispatcher("/sport").forward(request, response);
			}
			else {
				doGet(request, response);
			}
		}
		else {
			doGet(request, response);
		}
	}

}
