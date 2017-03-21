package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MShortReviewExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MShortReviewMapper;
import cn.scau.edu.ssm.movietalk.po.MShortReview;
import cn.scau.edu.ssm.movietalk.po.MShortReviewExt;
import cn.scau.edu.ssm.movietalk.po.MShortReviewVO;
import cn.scau.edu.ssm.movietalk.service.MShortReviewService;

public class MShortReviewServiceImpl implements MShortReviewService {
	@Autowired
	private MShortReviewExtMapper mShortReviewExtMapper;
	@Autowired
	private MShortReviewMapper mShortReviewMapper;
	
	
	@Override
	public MShortReviewVO getShortReviwe(int page, int size, int mid) {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		MShortReviewVO shortReviewVO = new MShortReviewVO();
		List<MShortReviewExt> mshortReview = mShortReviewExtMapper.selectByMid(mid);
		int count = mshortReview.size();
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
		shortReviewVO.setCount(count);
		shortReviewVO.setPageCount(pageCount);
		shortReviewVO.setPage(page);
		shortReviewVO.setShrotReview(mshortReview.subList(startPage, endPage));
		return shortReviewVO;
	}


	@Override
	public int insertShortReview(MShortReview shortReview) {
		return mShortReviewMapper.insertSelective(shortReview);
	}


	@Override
	public int AddSuppose(int id) {
		return mShortReviewExtMapper.addSuppose(id);
	}


	@Override
	public int cancelSuppose(int id) {
		return mShortReviewExtMapper.cancelSuppose(id);
	}

}
