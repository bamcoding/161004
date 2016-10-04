package net.gondor.articles.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.gondor.articles.vo.ArticleVO;

public interface ArticleBiz {
	public List<ArticleVO> getArticleList();
	public ArticleVO getArticle(String id, HttpServletRequest request);
	public boolean writeArticle(ArticleVO article, HttpServletRequest request);
	public void deleteArticle(String id);
	public boolean updateRecommand(String id);
	
}
