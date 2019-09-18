package kr.or.ddit.mvc.model;

import java.util.List;

public class Main {
	private List<String> userId;
	private Addr addr;
	
	private List<Addr> addrList;

	public final List<String> getUserId() {
		return userId;
	}

	public final void setUserId(List<String> userId) {
		this.userId = userId;
	}

	public final Addr getAddr() {
		return addr;
	}

	public final void setAddr(Addr addr) {
		this.addr = addr;
	}

	public final List<Addr> getAddrList() {
		return addrList;
	}

	public final void setAddrList(List<Addr> addrList) {
		this.addrList = addrList;
	}

	@Override
	public String toString() {
		return "Main [userId=" + userId + ", addr=" + addr + ", addrList=" + addrList + "]";
	}
}
