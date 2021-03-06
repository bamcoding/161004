package com.ktds.board.user.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.support.Param;

public class ViewSignInPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param = new Param();

	public ViewSignInPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorCode = param.getStringParam(request, "errorCode");
		String viewPath = "/WEB-INF/view/user/signIn.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("errorCode", errorCode);
		rd.forward(request, response);
	}

}
