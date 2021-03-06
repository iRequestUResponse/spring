package kr.or.ddit.common.model;

public class Page {
	private int page, size;

	public Page() {}
	
	public Page(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public int getPage() {
		return page == 0 ? 1 : page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size == 0 ? 10 : size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", size=" + size + "]";
	}
}
