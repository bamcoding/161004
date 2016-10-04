package net.gondor.articles.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.gondor.articles.dao.ArticleDao;
import net.gondor.articles.dao.ArticleDaoImpl;
import net.gondor.articles.vo.ArticleVO;
import net.gondor.constants.Session;
import net.gondor.users.dao.UserDao;
import net.gondor.users.dao.UserDaoImpl;
import net.gondor.users.vo.UserVO;

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
	public ArticleVO getArticle(String id, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute(Session.SESSION_INFO);
		UserDao userDao = new UserDaoImpl();
		userDao.addPoint(user.getId(), -1);
		dao.updateHitCount(id);
		return dao.getArticle(id);
	}


	@Override
	public void deleteArticle(String id) {
		// TODO Auto-generated method stub
		dao.deleteArticle(id);
	}

	@Override
	public boolean writeArticle(ArticleVO article, HttpServletRequest request) {
		boolean isTrue = dao.writeArticle(article) > 0;
		
		if(isTrue){
			HttpSession session = request.getSession();
			UserVO user = (UserVO)session.getAttribute(Session.SESSION_INFO);
			UserDao userDao = new UserDaoImpl();
			userDao.addPoint(user.getId(), 10);
		}
		return dao.writeArticle(article) > 0;
	}

	@Override
	public boolean updateRecommand(String id) {
		return dao.updateRecommand(id)>0;
	}

}
