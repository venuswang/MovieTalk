package cn.scau.edu.ssm.movietalk.po;

public class MLongReviewExt extends MLongReview {
	private String uname;
	private String filname;
	private boolean approve;
	private boolean anti;
	
	
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public boolean isAnti() {
		return anti;
	}
	public void setAnti(boolean anti) {
		this.anti = anti;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFilname() {
		return filname;
	}
	public void setFilname(String filname) {
		this.filname = filname;
	}
	
}
