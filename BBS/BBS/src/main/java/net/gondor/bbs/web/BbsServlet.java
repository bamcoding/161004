package net.gondor.bbs.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.bbs.dao.BbsDao;
import net.gondor.bbs.dao.BbsDaoImpl;
import net.gondor.bbs.vo.BbsVO;

public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BbsDao dao;
	
	public BbsServlet() {
        super();
        dao = new BbsDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BbsVO> bbsVOs = dao.getAllBbs();
		String viewPath = "/WEB-INF/view/bbs.jsp";
		String writeBbs = "/WEB-INF/view/writeBbs.jsp";		
		RequestDispatcher rd = request.getRequestDispatcher(viewPath); 
		
		request.setAttribute("bbsVOs", bbsVOs);
		request.setAttribute("writeBbs", writeBbs);
		rd.forward(request, response);
	}
}
