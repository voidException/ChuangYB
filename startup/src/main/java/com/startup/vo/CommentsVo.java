package com.startup.vo;

import com.startup.pojo.Comments;

public class CommentsVo {
	
	private Comments comments;
	private String timeString;
	private String UserPhotoPath;
	
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public String getUserPhotoPath() {
		return UserPhotoPath;
	}
	public void setUserPhotoPath(String userPhotoPath) {
		UserPhotoPath = userPhotoPath;
	}
	
	
}
