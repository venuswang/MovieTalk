package cn.scau.edu.ssm.movietalk.service;

import cn.scau.edu.ssm.movietalk.po.MLongReview;
import cn.scau.edu.ssm.movietalk.po.MLongReviewExt;
import cn.scau.edu.ssm.movietalk.po.MLongReviewVO;

public interface MLongReviewService {
	public MLongReviewVO getLongReview(int page, int size, int mid) throws Exception;
	public MLongReviewVO getAllReviews(int page, int size) throws Exception;
	public int insertLongReview(MLongReview longReview) throws Exception;
	public MLongReviewExt getSingleLongReview(int id) throws Exception;
	public int addLongSuppose(int id) throws Exception;
	public int cancelLongSuppose(int id) throws Exception;
	public int addLongAnti(int id) throws Exception;
	public int cancelLongAnti(int id) throws Exception;
}
