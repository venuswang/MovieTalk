package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MReviewReplyExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MReviewReplyMapper;
import cn.scau.edu.ssm.movietalk.po.MReviewReply;
import cn.scau.edu.ssm.movietalk.po.MReviewReplyExample;
import cn.scau.edu.ssm.movietalk.po.MReviewReplyExample.Criteria;
import cn.scau.edu.ssm.movietalk.po.MReviewReplyExt;
import cn.scau.edu.ssm.movietalk.po.MReviewReplyVO;
import cn.scau.edu.ssm.movietalk.service.MReviewReplyService;

public class MReviewReplyServiceImpl implements MReviewReplyService {
	@Autowired
	private MReviewReplyExtMapper mReviewReplyExtMapper;
	@Autowired
	private MReviewReplyMapper mReviewReplyMapper;
	
	@Override
	public MReviewReplyVO queryAllReply(int page, int size, int lid) throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		MReviewReplyVO replyVO = new MReviewReplyVO();
		List<MReviewReplyExt> replys = mReviewReplyExtMapper.selectByLid(lid);
		int count = replys.size();
		if(endPage >= count) {
			endPage = count;
		} else {
			endPage += 1;
		}
		int temp = count / size;
		int pageCount = (temp * size == count ? temp : temp + 1);
		if(pageCount == 0) {
			pageCount = 1;
		}
		replyVO.setCount(count);
		replyVO.setPage(page);
		replyVO.setPageCount(pageCount);
		replyVO.setReply(replys.subList(startPage, endPage));
		return replyVO;
	}

	@Override
	public int deleteReply(int id, int uid) throws Exception {
		MReviewReplyExample example = new MReviewReplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id).andUidEqualTo(uid);
		return mReviewReplyMapper.deleteByExample(example);
	}

	@Override
	public int insertReply(MReviewReply reply) throws Exception {
		return mReviewReplyMapper.insertSelective(reply);
	}

}
