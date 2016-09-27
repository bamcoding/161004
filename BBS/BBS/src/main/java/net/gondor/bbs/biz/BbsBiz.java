package net.gondor.bbs.biz;

import java.util.List;

import net.gondor.bbs.vo.BbsVO;

public interface BbsBiz {
	public List<BbsVO> getAllBbs();
	public void getBbsById(int id);
	
	public void deleteBbs(int id);
	
	public void updateHitCount();
	public void updateRecommandCount();
	public void updateAll(String subject, String content);
}
