package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MUserMapper;
import cn.scau.edu.ssm.movietalk.mapper.MUserMapperExt;
import cn.scau.edu.ssm.movietalk.po.MUserExample;
import cn.scau.edu.ssm.movietalk.po.MUserExample.Criteria;
import cn.scau.edu.ssm.movietalk.service.MUserService;

/**
 * Muser的实现service类
 * @author Administrator
 *
 */
public class MUserServiceImpl implements MUserService {
	@Autowired
	private MUserMapper mUserMapper;
	@Autowired
	private MUserMapperExt mUserMapperExt;
	
	@Override
	public int countMuser() throws Exception {
		MUserExample example = new MUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(false);
		int count = mUserMapper.countByExample(example);
		return count;
	}

	@Override
	public List<Map<String, Object>> selectSex() throws Exception {
		List<Integer> sexs = mUserMapperExt.selectSex();
		Map<Integer, Integer> sexMap = new HashMap<Integer, Integer>();
		for(int i=0; i < sexs.size(); i++) {
			Integer sex = sexs.get(i);
			if(sexMap.containsKey(sex)){
				sexMap.put(sex, sexMap.get(sex) + 1);
			} else {
				sexMap.put(sex, 1);
			}
		}
		List<Map<String,Object>> sexList = new ArrayList<Map<String,Object>>();
		Iterator<Integer> iterator = sexMap.keySet().iterator();
		while(iterator.hasNext()) {
			HashMap<String,Object> chartMap = new HashMap<String, Object>();
			Integer key = iterator.next();
			Integer value = sexMap.get(key);
			if(key == 0) {
				chartMap.put("category", "女");
			} else if(key == 1) {
				chartMap.put("category", "男");
			} else {
				chartMap.put("category", "不详");
			}
			chartMap.put("value", value);
			sexList.add(chartMap);
		}	
		return sexList;
	}

}
