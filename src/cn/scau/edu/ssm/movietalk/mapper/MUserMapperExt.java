package cn.scau.edu.ssm.movietalk.mapper;

import java.util.List;

import cn.scau.edu.ssm.movietalk.po.MUser;

public interface MUserMapperExt {

	public List<Integer> selectSex();
	public Integer selectUid(MUser user);
	public int insertUid(MUser user);
}
