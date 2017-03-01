package cn.scau.edu.ssm.movietalk.po;

import java.util.List;

/**
 * 影片类型的视图类
 * @author Administrator
 *
 */
public class TypeVO {
	private int pageCount;
	private List<MType> mType;
	private int count;
	private int page;
	private String filterParam;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<MType> getmType() {
		return mType;
	}
	public void setmType(List<MType> mType) {
		this.mType = mType;
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
