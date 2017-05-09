package com.innovation.evconnect.bos;

public class UsersBO {

	private long userID;
	private String username;
	private String password;
	private String userRole;
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public UsersBO(long userID, String username, String password, String userRole) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "UsersBO [userID=" + userID + ", username=" + username + ", password=" + password + ", userRole="
				+ userRole + "]";
	}
	
}
