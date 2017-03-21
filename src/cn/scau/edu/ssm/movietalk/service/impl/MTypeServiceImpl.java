package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MTypeExtMapper;
import cn.scau.edu.ssm.movietalk.po.MTypeExt;
import cn.scau.edu.ssm.movietalk.service.MTypeService;

public class MTypeServiceImpl implements MTypeService {
	@Autowired
	private MTypeExtMapper mTypeExtMapper;
	
	@Override
	public List<MTypeExt> queryAllType() throws Exception {
		return mTypeExtMapper.selectAllType();
	}

}
