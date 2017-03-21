package cn.scau.edu.ssm.movietalk.service;

import java.util.List;
import java.util.Map;

import cn.scau.edu.ssm.movietalk.po.MUser;

/**
 * 用户service类
 * @author Administrator
 *
 */
public interface MUserService {
	public int countMuser() throws Exception;
	public List<Map<String, Object>> selectSex() throws Exception;
	public int selectUid(MUser user) throws Exception;
	public int insertUid(MUser user) throws Exception;
	public int updateUid(MUser user) throws Exception;
	public int checkUser(String uname) throws Exception;
}
