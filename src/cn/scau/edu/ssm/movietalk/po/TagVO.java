package cn.scau.edu.ssm.movietalk.po;

import java.util.List;

/**
 * tag标签的视图类
 * @author Administrator
 *
 */
public class TagVO {
	private int pageCount;
	private List<MTag> mTag;
	private int count;
	private int page;
	private String filterParam;
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public List<MTag> getmTag() {
		return mTag;
	}
	
	public void setmTag(List<MTag> mTag) {
		this.mTag = mTag;
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
	
	
}
