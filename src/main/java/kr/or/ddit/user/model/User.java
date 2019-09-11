package kr.or.ddit.user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import encrypt.KISA_SHA256;

public class User {
	private String userId; // 사용자 아이디
	private String userNm; // 사용자 이름
	private String pass; // 사용자 비밀번호
	private String alias; // 별명

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reg_dt; // 등록일
	private String addr1; // 주소1
	private String addr2; // 주소2
	private String zipcode; // 우편번호
	private String filename; // 실제 파일명(사용자 업로드 파일명)
	private String realfilename; // 물리 파일명
	private String realfilename2; //

	public User() {
	}

	public User(String userId) {
		this.userId = userId;
	}

	public User(String userId, String userNm, String alias, Date reg_dt, String addr1, String addr2, String zipcode,
			String pass, String filename, String realfilename) {
		this.userId = userId;
		this.userNm = userNm;
		this.alias = alias;
		this.reg_dt = reg_dt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.pass = pass;
		this.filename = filename;
		this.realfilename = realfilename;
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

	public final String getPass() {
		return pass;
	}

	public final void setPass(String pass) {
		this.pass = pass;
	}

	public final String getAlias() {
		return alias;
	}

	public final void setAlias(String alias) {
		this.alias = alias;
	}

	public final Date getReg_dt() {
		return reg_dt;
	}

	public final void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public final String getAddr1() {
		return addr1;
	}

	public final void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public final String getAddr2() {
		return addr2;
	}

	public final void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public final String getZipcode() {
		return zipcode;
	}

	public final void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public final String getFilename() {
		return filename;
	}

	public final void setFilename(String filename) {
		this.filename = filename;
	}

	public final String getRealfilename() {
		return realfilename;
	}

	public final void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}

	public final String getRealfilename2() {
		return realfilename2;
	}

	public final void setRealfilename2(String realfilename2) {
		this.realfilename2 = realfilename2;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNm=" + userNm + ", pass=" + pass + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename
				+ ", realfilename=" + realfilename + ", realfilename2=" + realfilename2 + "]";
	}

	public boolean checkLoginValidate(String userId, String pass) {
		// 암호화 문장끼리 비교
		return userId.equals(this.getUserId()) && KISA_SHA256.encrypt(pass).equals(this.getPass());
	}
}
