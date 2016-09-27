package net.gondor.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gondor.bbs.vo.BbsVO;

public class BbsDaoImpl implements BbsDao {

	@Override
	public List<BbsVO> getAllBbs() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	CONT ");
			query.append("			, TO_CHAR(CRT_DT, 'YYYY/MM/DD HH24:MI:SS') CRT_DT  ");
			query.append("			, CRTR_NM ");
			query.append("			, HIT_CNT_NUMBER ");
			query.append("			, ID ");
			query.append("			, RCMD_CNT ");
			query.append("			 , TITLE ");
			query.append(" FROM		BBS ");
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();

			List<BbsVO> bbsVOs = new ArrayList<BbsVO>();
			BbsVO bbsVO = null;
			while (rs.next()) {
				bbsVO = new BbsVO();
				bbsVO.setContent(rs.getString("CONT"));
				bbsVO.setCreatDate(rs.getString("CRT_DT"));
				bbsVO.setCreater(rs.getString("CRTR_NM"));
				bbsVO.setHitCount(rs.getInt("HIT_CNT_NUMBER"));
				bbsVO.setId(rs.getInt("ID"));
				bbsVO.setRecommandCount(rs.getInt("RCMD_CNT"));
				bbsVO.setTitle(rs.getString("TITLE"));

				bbsVOs.add(bbsVO);
			}

			return bbsVOs;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}

	@Override
	public BbsVO getBbsById(int id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	CONT ");
			query.append("			, TO_CHAR(CRT_DT, 'YYYY/MM/DD HH24:MI:SS') CRT_DT  ");
			query.append("			, CRTR_NM ");
			query.append("			, HIT_CNT_NUMBER ");
			query.append("			, ID ");
			query.append("			, RCMD_CNT ");
			query.append("			 , TITLE ");
			query.append(" FROM		BBS ");
			query.append(" WHERE	ID=? ");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			BbsVO bbsVO = null;
			if (rs.next()) {
				bbsVO = new BbsVO();
				bbsVO.setContent(rs.getString("CONT"));
				bbsVO.setCreatDate(rs.getString("CRT_DT"));
				bbsVO.setCreater(rs.getString("CRTR_NM"));
				bbsVO.setHitCount(rs.getInt("HIT_CNT_NUMBER"));
				bbsVO.setId(rs.getInt("ID"));
				bbsVO.setRecommandCount(rs.getInt("RCMD_CNT"));
				bbsVO.setTitle(rs.getString("TITLE"));

			}
			return bbsVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}

	@Override
	public void deleteBbs(int id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" DELETE ");
			query.append(" FROM		BBS ");
			query.append(" WHERE	ID=? ");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}

	@Override
	public void updateHitCount(int id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE BBS");
			query.append(" SET HIT_CNT_NUMBER=HIT_CNT_NUMBER+1 ");
			query.append(" WHERE ID=? ");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}

	public void minusHitCount(int id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE BBS");
			query.append(" SET HIT_CNT_NUMBER=HIT_CNT_NUMBER-1 ");
			query.append(" WHERE ID=? ");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}

	@Override
	public void updateRecommandCount(int id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE BBS ");
			query.append(" SET RCMD_CNT=RCMD_CNT+1 ");
			query.append(" WHERE ID=? ");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}

	@Override
	public void updateAll(int id, String title, String content) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE BBS ");
			query.append(" SET TITLE=?, CONT=? ");
			query.append(" WHERE ID=? ");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}

	@Override
	public void insertBbs(String title, String content, String creater) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "bbs");
			StringBuffer query = new StringBuffer();
			query.append(" INSERT INTO BBS	( ");
			query.append("					TITLE, CONT, CRTR_NM, CRT_DT, ");
			query.append("					HIT_CNT_NUMBER, RCMD_CNT, ID) ");
			query.append(" VALUES( ?, ?, ?, SYSDATE, 0, 0, ID_SEQ.NEXTVAL) ");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, creater);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	}
}
