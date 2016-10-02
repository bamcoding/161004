package net.gondor.articles.biz;

import java.util.List;

import net.gondor.articles.dao.ArticleDao;
import net.gondor.articles.dao.ArticleDaoImpl;
import net.gondor.articles.vo.ArticleVO;

public class ArticleBizImpl implements ArticleBiz {

	ArticleDao dao;

	public ArticleBizImpl() {
		super();
		dao = new ArticleDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ArticleVO> getArticleList() {
		return dao.getArticleList();
	}

	@Override
	public ArticleVO getArticle(String id) {
		return dao.getArticle(id);
	}


	@Override
	public void deleteArticle(String id) {
		// TODO Auto-generated method stub
		dao.deleteArticle(id);
	}

	@Override
	public boolean writeArticle(ArticleVO article) {
		// TODO Auto-generated method stub
		return dao.writeArticle(article) > 0;
	}

}
