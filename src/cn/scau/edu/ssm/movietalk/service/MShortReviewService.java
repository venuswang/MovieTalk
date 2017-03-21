package cn.scau.edu.ssm.movietalk.service;

import cn.scau.edu.ssm.movietalk.po.MShortReview;
import cn.scau.edu.ssm.movietalk.po.MShortReviewVO;

public interface MShortReviewService {
	public MShortReviewVO getShortReviwe(int page, int size, int mid);
	public int insertShortReview(MShortReview shortReview);
	public int AddSuppose(int id);
	public int cancelSuppose(int id);
}
