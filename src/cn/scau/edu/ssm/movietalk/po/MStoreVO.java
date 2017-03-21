package cn.scau.edu.ssm.movietalk.po;

import java.util.List;

public class MStoreVO {
	private int pageCount;
	private int count;
	private int page;
	private List<MStoreExt> store;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<MStoreExt> getStore() {
		return store;
	}
	public void setStore(List<MStoreExt> store) {
		this.store = store;
	}
	
	
}
