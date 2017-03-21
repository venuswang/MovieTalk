package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MLongReviewExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MLongReviewMapper;
import cn.scau.edu.ssm.movietalk.po.MLongReview;
import cn.scau.edu.ssm.movietalk.po.MLongReviewExt;
import cn.scau.edu.ssm.movietalk.po.MLongReviewVO;
import cn.scau.edu.ssm.movietalk.service.MLongReviewService;

public class MLongReviewServiceImpl implements MLongReviewService {
	@Autowired
	private MLongReviewExtMapper mLongReviewExtMapper;
	@Autowired
	private MLongReviewMapper mLongReviewMapper;
	
	
	@Override
	public MLongReviewVO getLongReview(int page, int size, int mid)
			throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		MLongReviewVO longReviewVO = new MLongReviewVO();
		List<MLongReviewExt> mLongReivew = mLongReviewExtMapper.selectByMid(mid);
		int count = mLongReivew.size();
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
		longReviewVO.setCount(count);
		longReviewVO.setPage(page);
		longReviewVO.setPageCount(pageCount);
		longReviewVO.setLongReview(mLongReivew.subList(startPage, endPage));
		return longReviewVO;
	}


	@Override
	public int insertLongReview(MLongReview longReview) throws Exception {
		return mLongReviewMapper.insertSelective(longReview);
	}


	@Override
	public MLongReviewExt getSingleLongReview(int id) throws Exception {
		return mLongReviewExtMapper.selectById(id);
	}


	@Override
	public int addLongSuppose(int id) throws Exception {
		return mLongReviewExtMapper.addLongSuppose(id);
	}


	@Override
	public int cancelLongSuppose(int id) throws Exception {
		return mLongReviewExtMapper.cancelLongSuppose(id);
	}


	@Override
	public int addLongAnti(int id) throws Exception {
		return mLongReviewExtMapper.addLongAnti(id);
	}


	@Override
	public int cancelLongAnti(int id) throws Exception {
		return mLongReviewExtMapper.cancelLongAnti(id);
	}


	@Override
	public MLongReviewVO getAllReviews(int page, int size) throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		MLongReviewVO longReviewVO = new MLongReviewVO();
		List<MLongReviewExt> mLongReivew = mLongReviewExtMapper.selectAllReview();
		int count = mLongReivew.size();
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
		longReviewVO.setCount(count);
		longReviewVO.setPage(page);
		longReviewVO.setPageCount(pageCount);
		longReviewVO.setLongReview(mLongReivew.subList(startPage, endPage));
		return longReviewVO;
	}

}
