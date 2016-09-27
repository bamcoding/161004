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

public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BbsDao dao = new BbsDaoImpl();
		BbsVO bbsVO = new BbsVO();
		String idParam = request.getParameter("id");
		String recommand = request.getParameter("recommand");
		
		int id = Integer.parseInt(idParam);
		
		if(recommand==null||recommand.length()==0)
		{
			recommand = "";
		}else if(recommand.equals("press")){
			dao.updateRecommandCount(id);
			dao.minusHitCount(id);
		}
		
		//글을 자세히 보면 조회수가 증가한다.
		dao.updateHitCount(id);
		
		//하나의 row을 저장한다.
		bbsVO = dao.getBbsById(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/detail.jsp");
		//jsp로 정보를 보낸다.
		request.setAttribute("bbsVO", bbsVO);
		rd.forward(request, response);
	}
}
