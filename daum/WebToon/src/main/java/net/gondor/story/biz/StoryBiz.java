package net.gondor.story.biz;

import java.util.List;

import net.gondor.story.vo.StoryVO;


public interface StoryBiz {
	public List<StoryVO> getStories();
	public StoryVO getStory(String id);
	public boolean writeStory(StoryVO story);
	public void deleteStory(String id);
	
}
