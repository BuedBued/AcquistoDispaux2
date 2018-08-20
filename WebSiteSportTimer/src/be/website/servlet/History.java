package be.website.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.website.beans.BRecord;
import be.website.beans.BUser;
import be.website.dao.DAOFactory;
import be.website.dao.DAO_Record;

@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public History() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		BUser currentUser = (BUser)session.getAttribute("user");		
		int idCurrentCategory = Integer.parseInt(request.getParameter("id"));
		
		DAO_Record daoR = (DAO_Record)DAOFactory.get().getDAORecord();
		ArrayList<BRecord> listRecord = daoR.selectAll();
		ArrayList<BRecord> listRecordUser = new ArrayList<BRecord>();
		
		
		for(BRecord r : listRecord) {
			if(r.getCategory().getId() == (idCurrentCategory) && r.getUser().getId() == currentUser.getId()) {
				listRecordUser.add(r);
			}
		}	
				
		request.setAttribute("listRecord", listRecordUser);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/history.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
