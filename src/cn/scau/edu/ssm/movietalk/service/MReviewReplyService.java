package cn.scau.edu.ssm.movietalk.service;

import cn.scau.edu.ssm.movietalk.po.MReviewReply;
import cn.scau.edu.ssm.movietalk.po.MReviewReplyVO;

public interface MReviewReplyService {
	public MReviewReplyVO queryAllReply(int page, int size, int lid) throws Exception;
	public int deleteReply(int id, int uid) throws Exception;
	public int insertReply(MReviewReply reply) throws Exception;
}
