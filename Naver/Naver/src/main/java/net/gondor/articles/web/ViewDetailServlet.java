package net.gondor.articles.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.articles.biz.ArticleBiz;
import net.gondor.articles.biz.ArticleBizImpl;
import net.gondor.articles.vo.ArticleVO;
import net.gondor.support.Param;

/**
 * Servlet implementation class ViewDetailServlet
 */
public class ViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param;
	private ArticleBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailServlet() {
        super();
        param = new Param();
        biz = new ArticleBizImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = param.getStringParam(request, "id");
		//에러 잘못된 선택입니다.
		
		ArticleVO article = biz.getArticle(id, request);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/detail.jsp");
		request.setAttribute("article", article);
		rd.forward(request, response);
	
	}

}
