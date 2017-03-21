package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MTagExtMapper;
import cn.scau.edu.ssm.movietalk.po.MTagExt;
import cn.scau.edu.ssm.movietalk.service.MTagService;

public class MTagServiceImpl implements MTagService {
	@Autowired
	private MTagExtMapper mTagExtMapper;
	
	
	@Override
	public List<MTagExt> queryAllTag() throws Exception {
		return mTagExtMapper.selectAllTag();
	}

}
