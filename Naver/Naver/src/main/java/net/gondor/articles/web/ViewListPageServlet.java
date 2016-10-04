package net.gondor.articles.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gondor.articles.biz.ArticleBiz;
import net.gondor.articles.biz.ArticleBizImpl;
import net.gondor.articles.vo.ArticleVO;
import net.gondor.constants.Session;
import net.gondor.users.vo.UserVO;

public class ViewListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz biz;
    public ViewListPageServlet() {
        super();
        biz = new ArticleBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ArticleVO> articles = biz.getArticleList();
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute(Session.SESSION_INFO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/hucloud.jsp");
		request.setAttribute("articles", articles);
		request.setAttribute("user", user);
		rd.forward(request, response);
	}
}
