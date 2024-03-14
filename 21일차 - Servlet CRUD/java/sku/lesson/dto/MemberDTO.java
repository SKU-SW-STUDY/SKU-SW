package sku.lesson.dto;

import java.sql.Timestamp;

public class MemberDTO {
	private String userId;
	private String userName;
	private String userPwd;
	private Timestamp registDate;
	
	public MemberDTO(String userId, String userName, String userPwd, Timestamp registDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.registDate = registDate;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public Timestamp getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Timestamp registDate) {
		this.registDate = registDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", registDate="
				+ registDate + "]";
	}

}
