package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MRealiseDairyExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MRealiseDairyMapper;
import cn.scau.edu.ssm.movietalk.po.MRealiseDairy;
import cn.scau.edu.ssm.movietalk.service.MRealiseDairyService;

public class MRealiseDairyServiceImpl implements MRealiseDairyService {
	@Autowired
	private MRealiseDairyExtMapper mRealiseDairyExtMapper;
	@Autowired
	private MRealiseDairyMapper mRealiseDairyMapper;
	
	@Override
	public List<Map<String, Object>> selectIsp() throws Exception {
		List<String> isps = mRealiseDairyExtMapper.selectIsp();
		Map<String,Integer> ispMap = new HashMap<String, Integer>();
		for(int i=0; i < isps.size(); i++) {
			String isp = isps.get(i);
			if(ispMap.containsKey(isp)){
				ispMap.put(isp, ispMap.get(isp) + 1);
			} else {
				ispMap.put(isp, 1);
			}
		}
		List<Map<String,Object>> ispList = new ArrayList<Map<String,Object>>();
		Iterator<String> iterator = ispMap.keySet().iterator();
		while(iterator.hasNext()) {
			HashMap<String,Object> chartMap = new HashMap<String, Object>();
			String key = iterator.next();
			Integer value = ispMap.get(key);
			chartMap.put("category", key);
			chartMap.put("value", value);
			ispList.add(chartMap);
		}
		return ispList;
	}

	@Override
	public int insertIsp(MRealiseDairy dairy) throws Exception {
		return mRealiseDairyMapper.insertSelective(dairy);
	}

}
