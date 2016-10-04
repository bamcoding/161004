package com.ktds.board.articles.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.articles.biz.ArticlesBiz;
import com.ktds.board.articles.biz.ArticlesBizImpl;
import com.ktds.board.articles.vo.ArticlesVO;
import com.ktds.board.support.DownloadUtil;
import com.ktds.board.support.Param;

public class DoDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticlesBiz articlesBiz;
    public DoDownloadServlet() {
        super();
        articlesBiz = new ArticlesBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	/**
	 * 하나의 게시글에는 하나의 파일이 있습니다.
	 * 이것은 1:1관계이다
	 * board/download? 처럼 get 방식으로 파일 이름을 보내서 하나의 파일을 다운로드 하는 방식이 있다.
	 * 그러나 1개 이상의 파일이라면 이런 경우라면 파일테이블이 따로 나온다.
	 * 게시글과 1개이상의 파일은 1대 다 관계이며 파일 테이블은 게시글의 fk와 스스로의 pk를 가진다.
	 * 우리는 1:1관계를 해본다
	 */
		
		String articleId = Param.getStringParam(request, "articleId");
		String fileName = articlesBiz.getFileNameOfArticleBy(articleId);
		if(fileName !=null &&fileName.length() > 0){
			DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\board\\uploadfiles");
			
			downloadUtil.download(request, response, fileName, fileName);
		}
		/**
		 * 사용자의 정보를 가져와서 파일이름을 알고 스트림에 흘려준다.
		 */
	}

}
