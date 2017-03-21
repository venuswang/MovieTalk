package cn.scau.edu.ssm.movietalk.po;

import java.util.List;

public class MListVO {
	private int pageCount;
	private int count;
	private int page;
	private String filterParam;
	private int tagid;
	private int typeid;
	private List<MListExt> mList;
	
	public int getTagid() {
		return tagid;
	}
	public void setTagid(int tagid) {
		this.tagid = tagid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
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
	public String getFilterParam() {
		return filterParam;
	}
	public void setFilterParam(String filterParam) {
		this.filterParam = filterParam;
	}
	public List<MListExt> getmList() {
		return mList;
	}
	public void setmList(List<MListExt> mList) {
		this.mList = mList;
	}
	
	
}
