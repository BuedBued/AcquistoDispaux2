package be.website.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import be.website.beans.BUser;
import be.website.dao.*;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int ArrayList = 0;
       
    public Home() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user")!=null) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/sport.jsp").forward(request, response);
			return;
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		HttpSession session = request.getSession();
		
		ArrayList<BUser> listUser = DAOFactory.get().getDAOUser().selectAll();
		
		String login = (String)request.getAttribute("login");
		String pw = (String)request.getAttribute("pw");
		
		int count = 0;
		boolean userExist = false;
		
		do {
			if(listUser.get(count).getLogin().equals(login)) {
				userExist = true;
			}			
			count++;
		}while(userExist == false && count < listUser.size());
		
		if(userExist) {
			count--;
			
			if(listUser.get(count).getPassword().equals(pw)) {
				session.setAttribute("user", listUser.get(count));
			}
		}
		
		doGet(request, response);		
	}
}
