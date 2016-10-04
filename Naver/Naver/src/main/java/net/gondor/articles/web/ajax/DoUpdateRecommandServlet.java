package net.gondor.articles.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.articles.biz.ArticleBiz;
import net.gondor.articles.biz.ArticleBizImpl;
import net.gondor.support.Param;

public class DoUpdateRecommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleBiz biz;
    private Param param = new Param();
    public DoUpdateRecommandServlet() {
        super();
        biz = new ArticleBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = param.getStringParam(request, "id");
		boolean isTrue = biz.updateRecommand(id);
		
		PrintWriter out = response.getWriter();
		out.print(isTrue+"");
		out.flush();
		out.close();
	}
}
