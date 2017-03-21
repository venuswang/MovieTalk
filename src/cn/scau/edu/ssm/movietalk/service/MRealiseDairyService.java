package cn.scau.edu.ssm.movietalk.service;

import java.util.List;
import java.util.Map;

import cn.scau.edu.ssm.movietalk.po.MRealiseDairy;

/**
 * 操作MRealiseDairy的service
 * @author Administrator
 *
 */
public interface MRealiseDairyService {
	public List<Map<String, Object>> selectIsp() throws Exception;
	public int insertIsp(MRealiseDairy dairy) throws Exception;
}
