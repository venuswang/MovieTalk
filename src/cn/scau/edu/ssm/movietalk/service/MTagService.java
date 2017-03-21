package cn.scau.edu.ssm.movietalk.service;

import java.util.List;

import cn.scau.edu.ssm.movietalk.po.MTagExt;

public interface MTagService {
	public List<MTagExt> queryAllTag() throws Exception;
}
