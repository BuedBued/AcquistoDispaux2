package be.website.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.website.beans.BCategory;
import be.website.beans.BRecord;
import be.website.beans.BUser;
import be.website.dao.DAOFactory;
import be.website.dao.DAO_Category;
import be.website.dao.DAO_Record;

@WebServlet("/Records")
public class Records extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Records() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idCurrentCategory = Integer.parseInt(request.getParameter("id"));				
		DAO_Category daoC = (DAO_Category)DAOFactory.get().getDAOCategory();
		BCategory currentCategory =  daoC.select(idCurrentCategory);
		
		DAO_Record daoR = (DAO_Record)DAOFactory.get().getDAORecord();
		ArrayList<BRecord> listRecord = daoR.selectAll();
		ArrayList<BRecord> listRecordCat = new ArrayList<BRecord>();
		ArrayList<BRecord> listBestRecord = new ArrayList<BRecord>();
		ArrayList<BUser> listUserCat = new ArrayList<BUser>();
		
		for(BRecord r : listRecord) {
			if(r.getCategory().getId() == (idCurrentCategory)) {
				listRecordCat.add(r);
			}
		}
		
		for(BRecord r : listRecordCat) {
			if(!listUserCat.contains(r.getUser())){
				listUserCat.add(r.getUser());
			}
		}
		
		for(BUser u : listUserCat) {
			ArrayList<BRecord> listRecordUser = new ArrayList<BRecord>();
			for(BRecord r : listRecordCat) {
				if(r.getUser() == u) {
					listRecordUser.add(r);
				}
			}
			
			BRecord userBestTime = listRecordUser.get(0);
			for(BRecord r : listRecordUser) {
				if(r.getTime() > userBestTime.getTime()) {
					userBestTime = r;
				}
			}
			
			listBestRecord.add(userBestTime);
		}		
				
		request.setAttribute("category", currentCategory);
		request.setAttribute("listRecord", listBestRecord);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/records.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
