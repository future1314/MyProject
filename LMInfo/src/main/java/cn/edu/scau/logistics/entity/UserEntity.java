package cn.edu.scau.logistics.entity;

public class UserEntity {
	private int userId;
	private String account;
	private String userName;
	private String userPassword;
	private String userTel;
	private String userEmail;
	private String role;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", account=" + account + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userTel=" + userTel + ", userEmail=" + userEmail + ", role=" + role + "]";
	}
	
	
	
}
