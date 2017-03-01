package cn.scau.edu.ssm.movietalk.service;

import java.util.List;
import java.util.Map;

/**
 * 用户service类
 * @author Administrator
 *
 */
public interface MUserService {
	public int countMuser() throws Exception;
	public List<Map<String, Object>> selectSex() throws Exception;
}
