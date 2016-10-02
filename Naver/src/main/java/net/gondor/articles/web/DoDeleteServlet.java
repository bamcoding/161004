package net.gondor.articles.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.articles.biz.ArticleBiz;
import net.gondor.articles.biz.ArticleBizImpl;
import net.gondor.support.Param;

public class DoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param;
	private ArticleBiz biz;
    public DoDeleteServlet() {
        super();
        param = new Param();
        biz = new ArticleBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = param.getStringParam(request, "id");
		
		biz.deleteArticle(id);
		response.sendRedirect("./viewList");
	}

}
