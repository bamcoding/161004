package net.gondor.bbs.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.bbs.dao.BbsDao;
import net.gondor.bbs.dao.BbsDaoImpl;
import net.gondor.bbs.vo.BbsVO;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsDao dao = new BbsDaoImpl();
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);
		BbsVO bbsVO = dao.getBbsById(id);
		bbsVO.setContent(bbsVO.getContent().replaceAll("<br/>", "\n"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update.jsp");
		request.setAttribute("bbsVO", bbsVO);
		rd.forward(request, response);
	}

}
