package net.gondor.bbs.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.bbs.dao.BbsDao;
import net.gondor.bbs.dao.BbsDaoImpl;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoWriteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BbsDao dao = new BbsDaoImpl();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");
		String creater = request.getParameter("creater");
		dao.insertBbs(title, content, creater);
		response.sendRedirect("./bbs");

	}

}
