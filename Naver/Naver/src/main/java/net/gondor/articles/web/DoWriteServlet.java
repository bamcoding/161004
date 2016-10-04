package net.gondor.articles.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gondor.articles.biz.ArticleBiz;
import net.gondor.articles.biz.ArticleBizImpl;
import net.gondor.articles.vo.ArticleVO;
import net.gondor.constants.Session;
import net.gondor.support.Param;
import net.gondor.users.vo.UserVO;

/**
 * Servlet implementation class DoWriteServlet
 */
public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param;
	private ArticleBiz biz; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoWriteServlet() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = param.getStringParam(request, "title");
		String content = param.getStringParam(request, "content");
		
		if(title.length()==0){
			response.sendRedirect("./write?error=1");
			return;
		}
		if(content.length()==0){
			response.sendRedirect("./write?error=2");
			return;
		}
		
		content = content.replace("\n", "<br/>");
		
		HttpSession session = request.getSession(); 
		UserVO userInfo = (UserVO)session.getAttribute(Session.SESSION_INFO);
		String userNickname = userInfo.getNickName();
				
		ArticleVO article = new ArticleVO();
		article.setTitle(title);
		article.setContent(content);
		article.setUserId(userNickname);
		
		boolean isSuccess = biz.writeArticle(article, request);
		if(isSuccess){
			response.sendRedirect("./viewList");
		}	
		else{
			response.sendRedirect("./write");
		}
		
	}

}
