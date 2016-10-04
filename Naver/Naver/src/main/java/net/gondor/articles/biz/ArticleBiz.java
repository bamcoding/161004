package net.gondor.articles.biz;

import java.util.List;

import net.gondor.articles.vo.ArticleVO;

public interface ArticleBiz {
	public List<ArticleVO> getArticleList();
	public ArticleVO getArticle(String id);
	public boolean writeArticle(ArticleVO article);
	public void deleteArticle(String id);
	
}
