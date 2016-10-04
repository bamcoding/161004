package com.ktds.board.articles.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.articles.biz.ArticlesBiz;
import com.ktds.board.articles.biz.ArticlesBizImpl;
import com.ktds.board.support.Param;

public class IncreaseRecommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticlesBiz biz;
    Param param = new Param();
    public IncreaseRecommandServlet() {
        super();
        biz = new ArticlesBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = param.getStringParam(request, "id");
		
		boolean isTrue = biz.updateRecommandCount(id);
		System.out.println("알작스 " + isTrue);
		
		PrintWriter out = response.getWriter();
		out.print(isTrue +"");
		out.flush();
		out.close();
	}

}
