package cn.scau.edu.ssm.movietalk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MAdminMapper;
import cn.scau.edu.ssm.movietalk.po.MAdminExample;
import cn.scau.edu.ssm.movietalk.po.MAdminExample.Criteria;
import cn.scau.edu.ssm.movietalk.po.MAdminExtend;
import cn.scau.edu.ssm.movietalk.service.MAdminService;

public class MAdminServiceImpl implements MAdminService {
	@Autowired
	private MAdminMapper mAdminMapper;
	
	@Override
	public boolean checkMadmin(MAdminExtend mAdminExtend) throws Exception {
		if(mAdminExtend == null)
			return false;
		String uname = mAdminExtend.getUname();
		String pword = mAdminExtend.getPword();
		if(uname == null || uname.length() < 1 || uname.length() > 32 || pword == null || pword.length() < 1 || pword.length() > 50)
			return false;
		MAdminExample mAdminExample = new MAdminExample();
		Criteria criteria = mAdminExample.createCriteria();
		criteria.andUnameEqualTo(uname).andPwordEqualTo(pword).andStatusEqualTo(true);
		int count = mAdminMapper.countByExample(mAdminExample);
		if(count == 0)
			return false;
		return true;
	}

}
