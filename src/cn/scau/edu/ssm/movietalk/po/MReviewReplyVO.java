package cn.scau.edu.ssm.movietalk.po;

import java.util.List;

public class MReviewReplyVO {
	private int pageCount;
	private int count;
	private int page;
	private List<MReviewReplyExt> reply;
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
	public List<MReviewReplyExt> getReply() {
		return reply;
	}
	public void setReply(List<MReviewReplyExt> reply) {
		this.reply = reply;
	}
	
	
}
