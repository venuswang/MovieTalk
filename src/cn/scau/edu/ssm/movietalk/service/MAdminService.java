package cn.scau.edu.ssm.movietalk.service;

import cn.scau.edu.ssm.movietalk.po.MAdminExtend;

/**
 * 后台管理员操作的service
 * @author Administrator
 *
 */
public interface MAdminService {
	public boolean checkMadmin(MAdminExtend mAdminExtend) throws Exception;
}
