package net.gondor.bbs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.bbs.dao.BbsDao;
import net.gondor.bbs.dao.BbsDaoImpl;

public class DoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsDao dao = new BbsDaoImpl();
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);
		dao.deleteBbs(id);
		response.sendRedirect("./bbs");
	}
}
