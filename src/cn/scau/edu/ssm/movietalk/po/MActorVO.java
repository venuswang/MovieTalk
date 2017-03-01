package cn.scau.edu.ssm.movietalk.po;

import java.util.List;

public class MActorVO {
	private int pageCount;
	private int count;
	private int page;
	private String filterParam;
	private List<MActorExt> mActor;
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
	public List<MActorExt> getmActor() {
		return mActor;
	}
	public void setmActor(List<MActorExt> mActor) {
		this.mActor = mActor;
	}
	
}
