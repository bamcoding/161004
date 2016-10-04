package net.gondor.articles.vo;

import net.gondor.users.vo.UserVO;

/**
 * ATCL_ID, ATCL_TITLE, ATCL_CONT, 
 * USR_ID, MENU_ID, HIT_CNT, 
 * RCMD_CNT, CRT_DT
 * @author Lee
 *
 */
public class ArticleVO {
	private int hitCount;
	private int recommendCount;
	private String Id;
	private String title;
	private String content;
	private String userId;
	private String menuId;
	private String createdDate;
	
	UserVO userVO;

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
}
