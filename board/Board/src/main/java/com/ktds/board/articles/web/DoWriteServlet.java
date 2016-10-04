package com.ktds.board.articles.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.board.articles.biz.ArticlesBiz;
import com.ktds.board.articles.biz.ArticlesBizImpl;
import com.ktds.board.articles.vo.ArticlesVO;
import com.ktds.board.constants.Session;
import com.ktds.board.support.MultipartHttpServletRequest;
import com.ktds.board.support.MultipartHttpServletRequest.MultipartFile;
import com.ktds.board.support.Param;
import com.ktds.board.user.vo.UserVO;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticlesBiz biz;
	
    public DoWriteServlet() {
        super();
        biz = new ArticlesBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		String articleSubject = Param.getStringParam(request, "articleSubject");
//		String articleContent = Param.getStringParam(request, "articleContent");
		
		
		//사용자의 파일을 가져온다
		MultipartHttpServletRequest multipartRequest = 
				new MultipartHttpServletRequest(request);
		
		String articleSubject = multipartRequest.getParameter("articleSubject");
		String articleContent = multipartRequest.getParameter("articleContent");
		
		String fileName="";
		MultipartFile uploadFile = multipartRequest.getFile("file");
		
		//사용자가 파일을 업로드 했다면
		if(uploadFile.getFileSize() >0){
			//이 폴더를 실제로 만들어준다.
			File uploadFileDirectory =new File("D:\\board\\uploadfiles");
			
			//없다면 만들어라.
			if(!uploadFileDirectory.exists()){
				uploadFileDirectory.mkdirs();
			}
			//물리적인 장소에 파일을 써라
			uploadFile.write("D:\\board\\uploadfiles\\"+uploadFile.getFileName());
			fileName = uploadFile.getFileName();
		}
		
		
		if(articleSubject.length()==0){
			response.sendRedirect("/Board/board/write?errorCode=2");
			return;
		}
		if(articleContent.length()==0){			
			response.sendRedirect("/Board/board/write?errorCode=3");
			return;
		}
		
		HttpSession session = request.getSession(); 
		UserVO userInfo = (UserVO)session.getAttribute(Session.USER_INFO);
		String userNickname = userInfo.getUserNickname();
				
		ArticlesVO article = new ArticlesVO();
		article.setArticleSubject(articleSubject);
		article.setArticleContent(articleContent);
		article.setUserId(userNickname);
		article.setFileName(fileName);
		
		/**
		 * 지금은 이러한 과정들을 모두 모시해 버리고 업로드만 해버리는 겁니다
		 * 자카르타 프로젝트에서부터 시작된 것입니다.
		 * 이것은 라이브러리를 모두 분리해 놓았습니다.
		 * commons-io를 file-io가 사용합니다.
		 */
		boolean isSuccess = biz.writeArticles(article);
		if(isSuccess){
			response.sendRedirect("/Board/board/list");
		}	
		else{
			response.sendRedirect("Board/board/write?errorCode=1");
		}
	}

}
