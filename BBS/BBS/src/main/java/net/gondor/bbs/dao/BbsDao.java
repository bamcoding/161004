package net.gondor.bbs.dao;

import java.util.List;

import net.gondor.bbs.vo.BbsVO;

public interface BbsDao {
	public void insertBbs(String title, String content, String creater);
	public void updateAll(int id, String title, String content);
	public List<BbsVO> getAllBbs();
	public BbsVO getBbsById(int id);
	
	public void deleteBbs(int id);
	
	public void updateHitCount(int id);
	public void minusHitCount(int id);
	public void updateRecommandCount(int id);
}
