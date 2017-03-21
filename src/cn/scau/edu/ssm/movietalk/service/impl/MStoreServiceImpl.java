package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MStoreExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MStoreMapper;
import cn.scau.edu.ssm.movietalk.po.MStore;
import cn.scau.edu.ssm.movietalk.po.MStoreExample;
import cn.scau.edu.ssm.movietalk.po.MStoreExt;
import cn.scau.edu.ssm.movietalk.po.MStoreExample.Criteria;
import cn.scau.edu.ssm.movietalk.po.MStoreVO;
import cn.scau.edu.ssm.movietalk.service.MStoreService;

public class MStoreServiceImpl implements MStoreService {
	@Autowired
	private MStoreMapper mStoreMapper;
	@Autowired
	private MStoreExtMapper mStoreExtMapper;
	
	
	@Override
	public boolean isCollect(int uid, int mid) throws Exception {
		MStoreExample example = new MStoreExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid).andMidEqualTo(mid);
		int count = mStoreMapper.countByExample(example);
		if(count == 0)
			return false;
		else 
			return true;
	}


	@Override
	public int addCollect(MStore store) throws Exception {
		return mStoreMapper.insertSelective(store);
	}


	@Override
	public int cancelCollect(MStore store) throws Exception {
		MStoreExample example = new MStoreExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(store.getUid()).andMidEqualTo(store.getMid());
		return mStoreMapper.deleteByExample(example);
	}


	@Override
	public MStoreVO queryStore(int page, int size, int uid) throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		MStoreVO storeVO = new MStoreVO();
		List<MStoreExt> stores = mStoreExtMapper.selectALLByUid(uid);
		int count = stores.size();
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
		storeVO.setCount(count);
		storeVO.setPage(page);
		storeVO.setPageCount(pageCount);
		storeVO.setStore(stores.subList(startPage, endPage));
		return storeVO;
	}

}
