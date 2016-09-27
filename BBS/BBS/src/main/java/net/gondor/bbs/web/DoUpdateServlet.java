package net.gondor.bbs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.bbs.dao.BbsDao;
import net.gondor.bbs.dao.BbsDaoImpl;

/**
 * Servlet implementation class DoUpdateServlet
 */
public class DoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsDao dao = new BbsDaoImpl();
		String idParam = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int id = Integer.parseInt(idParam);
		content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");
		dao.updateAll(id, title, content);
		dao.minusHitCount(id);
		response.sendRedirect("./detail?id="+idParam);
	}

}
