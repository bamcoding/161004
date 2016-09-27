package net.gondor.bbs.vo;

public class BbsVO {
	private String title;
	private String content;
	private String creater;
	private String creatDate;
	private int id;
	private int hitCount;
	private int recommandCount;
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
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public int getRecommandCount() {
		return recommandCount;
	}
	public void setRecommandCount(int recommandCount) {
		this.recommandCount = recommandCount;
	}
	
	
}
