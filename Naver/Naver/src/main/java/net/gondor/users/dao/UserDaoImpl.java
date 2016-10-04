package net.gondor.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.gondor.support.DaoSupport;
import net.gondor.support.Query;
import net.gondor.support.QueryResult;
import net.gondor.users.vo.UserVO;

public class UserDaoImpl extends DaoSupport implements UserDao{

	@Override
	public int joinUser(final UserVO userVO) {
		return updateTable(new Query(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO USRS ( ");
				query.append("    USR_ID, USR_PWD, USR_NM, ");
				query.append("    CRT_DT, USR_NICK, USR_POINT) ");
				query.append(" VALUES ( 'US-'||TO_CHAR(SYSDATE,'YYYYMMDD')||'-'||LPAD(ATCL_ID_SEQ.NEXTVAL,6,0), ");
				query.append("  ?, ");
				query.append("  ?, ");
				query.append("  SYSDATE, ");
				query.append("  ?, 100) ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getPassword());
				pstmt.setString(2, userVO.getName());
				pstmt.setString(3, userVO.getNickName());
				
				return pstmt;
			}
			
		});
	}

	@Override
	public UserVO getUserBy(final UserVO user) {
		return (UserVO) getTable(new QueryResult(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT USR_ID, USR_PWD, USR_NM, ");
				query.append("    TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS' ) CRT_DT, USR_NICK,USR_POINT ");
				query.append(" FROM USRS ");
				query.append(" WHERE USR_NICK=? AND USR_PWD=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, user.getNickName());
				pstmt.setString(2, user.getPassword());
				
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				UserVO user=null;
				if(rs.next()){
					user=new UserVO();
					user.setId(rs.getString("USR_ID"));
					user.setNickName(rs.getString("USR_NICK"));
					user.setPassword(rs.getString("USR_PWD"));
					user.setName(rs.getString("USR_NM"));
					user.setCreatedDate(rs.getString("CRT_DT"));
					user.setPoint(rs.getInt("USR_POINT"));
				}
				return user;
			}
			
		});
	}

	@Override
	public int countUserId(final String nickName) {
		return (int) getTable(new QueryResult(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT COUNT(1) CNT ");
				query.append(" FROM USRS ");
				query.append(" WHERE USR_NICK=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, nickName);
				
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				int count = 0;
				if(rs.next()){
				 count = Integer.parseInt(rs.getString("CNT"));
				}
				return count;
			}
			
		});
	}

	@Override
	public int addPoint(String id, int value) {
		return updateTable(new Query(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE USRS ");
				query.append(" SET USR_POINT= USR_POINT + ? ");
				query.append(" WHERE USR_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setInt(1, value);
				pstmt.setString(2, id);
				return pstmt;
			}
		});
	}

}
