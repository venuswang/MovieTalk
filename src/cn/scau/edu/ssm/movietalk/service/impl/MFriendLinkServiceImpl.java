package cn.scau.edu.ssm.movietalk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MFriendlinkMapper;
import cn.scau.edu.ssm.movietalk.po.MFriendlinkExample;
import cn.scau.edu.ssm.movietalk.service.MFriendLinkService;

/**
 * 友情连接的service实现类
 * @author Administrator
 *
 */
public class MFriendLinkServiceImpl implements MFriendLinkService {
	@Autowired
	private MFriendlinkMapper mFriendlinkMapper;
	
	@Override
	public int countMFriendLink() throws Exception {
		MFriendlinkExample example = new MFriendlinkExample();
		int count = mFriendlinkMapper.countByExample(example);
		return count;
	}

}
