package kr.or.ddit.user.model;

import org.springframework.stereotype.Repository;

public class User {
	private String userId;
	private String userNm;
	private String alias;
	
	public User() {
	}
	
	public User(String userId) {
		this.userId = userId;
	}

	public final String getUserId() {
		return userId;
	}

	public final void setUserId(String userId) {
		this.userId = userId;
	}

	public final String getUserNm() {
		return userNm;
	}

	public final void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public final String getAlias() {
		return alias;
	}

	public final void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNm=" + userNm + ", alias=" + alias + "]";
	}
}
