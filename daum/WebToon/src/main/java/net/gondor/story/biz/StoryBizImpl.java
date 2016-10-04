package net.gondor.story.biz;

import java.util.List;

import net.gondor.story.dao.StoryDao;
import net.gondor.story.dao.StoryDaoImpl;
import net.gondor.story.vo.StoryVO;


public class StoryBizImpl implements StoryBiz {

	StoryDao dao;

	public StoryBizImpl() {
		super();
		dao = new StoryDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StoryVO> getStories() {
		return dao.getStories();
	}

	@Override
	public StoryVO getStory(String id) {
		return dao.getStory(id);
	}


	@Override
	public void deleteStory(String id) {
		// TODO Auto-generated method stub
		dao.deleteStory(id);
	}

	@Override
	public boolean writeStory(StoryVO article) {
		// TODO Auto-generated method stub
		return dao.writeStory(article) > 0;
	}

}
