package net.gondor.articles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gondor.articles.vo.ArticleVO;
import net.gondor.support.DaoSupport;
import net.gondor.support.Query;
import net.gondor.support.QueryResult;
import net.gondor.users.vo.UserVO;

public class ArticleDaoImpl extends DaoSupport implements ArticleDao{

	@Override
	public List<ArticleVO> getArticleList() {
		return (List<ArticleVO>) getTable(new QueryResult(){
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	ATCL_ID, ATCL_TITLE, ATCL_CONT, ");
				query.append("			USR_ID, MENU_ID, HIT_CNT, ");
				query.append("			RCMD_CNT, TO_CHAR(CRT_DT,'YYYY.MM.DD. HH24:MI') CRT_DT ");
				query.append(" FROM 	ARTICLES ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				List<ArticleVO> articles = new ArrayList<ArticleVO>();
				ArticleVO article = null;
				while(rs.next()){
					article = new ArticleVO();
					article.setId(rs.getString("ATCL_ID"));
					article.setTitle(rs.getString("ATCL_TITLE"));
					article.setContent(rs.getString("ATCL_CONT"));
					article.setUserId(rs.getString("USR_ID"));
					article.setMenuId(rs.getString("MENU_ID"));
					article.setHitCount(rs.getInt("HIT_CNT"));
					article.setRecommendCount(rs.getInt("RCMD_CNT"));
					article.setCreatedDate(rs.getString("CRT_DT"));
					
					articles.add(article);
				}
				
				return articles;
			}
			
		});
	}

	@Override
	public ArticleVO getArticle(String id) {
		return (ArticleVO)getTable(new QueryResult() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT	ATCL_ID, ATCL_TITLE, ATCL_CONT, ");
				query.append("			USR_ID, MENU_ID, HIT_CNT, ");
				query.append("			RCMD_CNT, TO_CHAR(CRT_DT,'YYYY.MM.DD. HH24:MI') CRT_DT ");
				query.append(" FROM 	ARTICLES ");
				query.append(" WHERE	ATCL_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, id);
				return pstmt;
			}
			
			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				ArticleVO article=null;
				if(rs.next()){
					article = new ArticleVO();
					article.setHitCount(rs.getInt("HIT_CNT"));
					article.setRecommendCount(rs.getInt("RCMD_CNT"));
					article.setId(rs.getString("ATCL_ID"));
					article.setTitle(rs.getString("ATCL_TITLE"));
					article.setContent(rs.getString("ATCL_CONT"));
					article.setUserId(rs.getString("USR_ID"));
					article.setMenuId(rs.getString("MENU_ID"));
					article.setCreatedDate(rs.getString("CRT_DT"));
				}
				return article;
			}
		});
	}

	@Override
	public int writeArticle(ArticleVO article) {
		return updateTable(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO NAVER.ARTICLES ( ");
				query.append("							ATCL_ID ");
				query.append("							, ATCL_TITLE ");
				query.append("							, USR_ID ");
				query.append("							, ATCL_CONT ");
				query.append("							, MENU_ID ");
				query.append("							, CRT_DT ");
				query.append("							, HIT_CNT ");
				query.append("							, RCMD_CNT) ");
				query.append("					VALUES ( ");
				query.append("							'AR-'||TO_CHAR(SYSDATE,'YYYYDDMM')||'-'||LPAD(ATCL_ID_SEQ.NEXTVAL,6,0) ");
				query.append("							,? ");
				query.append("							,? ");
				query.append("							,? ");
				query.append("							,'과제게시판' ");
				query.append("							,SYSDATE ");
				query.append("							,0 ");
				query.append("							,0) ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				System.out.println(article.getTitle());
				System.out.println(article.getUserId());
				System.out.println(article.getContent());
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getUserId());
				pstmt.setString(3, article.getContent());
				return pstmt;
			}
		});
	}

	@Override
	public void deleteArticle(String id) {
		updateTable(new Query() {
			
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" DELETE ");
				query.append(" FROM 	ARTICLES ");
				query.append(" WHERE	ATCL_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, id);
				return pstmt;
			}
		});
	}

}
