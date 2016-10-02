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
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print(" alert('제목을 입력하세요.');	");
			out.print("</script>");
			out.flush();
			out.close();
			response.sendRedirect("./write");
			return;
		}
		if(content.length()==0){
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print(" alert('내용을 입력하세요.');	");
			out.print("</script>");
			out.flush();
			out.close();
			response.sendRedirect("./write");
			return;
		}
		
		HttpSession session = request.getSession(); 
		UserVO userInfo = (UserVO)session.getAttribute(Session.SESSION_INFO);
		String userNickname = userInfo.getNickName();
				
		ArticleVO article = new ArticleVO();
		article.setTitle(title);
		article.setContent(content);
		article.setUserId(userNickname);
		
		boolean isSuccess = biz.writeArticle(article);
		if(isSuccess){
			response.sendRedirect("./viewList");
		}	
		else{
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print(" alert('서버에 문제가 발생하였습니다.');	");
			out.print("</script>");
			out.flush();
			out.close();
			response.sendRedirect("./write");
		}
		
	}

}
