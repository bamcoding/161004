package net.gondor.articles.dao;

import java.util.List;

import net.gondor.articles.vo.ArticleVO;

/**
 * 글쓰기, 리스트, 디테일, 삭제
 * @author Lee
 *
 */
public interface ArticleDao {
	public List<ArticleVO> getArticleList();
	public ArticleVO getArticle(String id);
	public int writeArticle(ArticleVO article);
	public void deleteArticle(String id);
}
