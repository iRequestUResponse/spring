package kr.or.ddit.batch.user.model;

public class User {
	private String userId;
	private String pass;

	public final String getUserId() {
		return userId;
	}

	public final void setUserId(String userId) {
		this.userId = userId;
	}

	public final String getPass() {
		return pass;
	}

	public final void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", pass=" + pass + "]";
	}
}
