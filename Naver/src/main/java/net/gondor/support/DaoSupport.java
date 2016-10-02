package net.gondor.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoSupport {
	/**
	 * 업데이트 한다.
	 * 결과 값을 int로 반환한다.
	 * @param query
	 * @return
	 */
	public int updateTable(Query query) {
		loadOracleClass();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = query.query(conn);
			int count = pstmt.executeUpdate();
			return count;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(null, pstmt, conn);
		}
	}
	
	/**
	 * DB에서 결과를 받아오는 메소드
	 * @param qr
	 * @return
	 */
	public Object getTable(QueryResult qr) {
		loadOracleClass();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			pstmt = qr.query(conn);

			rs = pstmt.executeQuery();

			return qr.makeObject(rs);

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(rs, pstmt, conn);
		}
	}

	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "NAVER", "NAVER");
	}

	private void loadOracleClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
