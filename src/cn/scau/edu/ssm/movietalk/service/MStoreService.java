package cn.scau.edu.ssm.movietalk.service;

import cn.scau.edu.ssm.movietalk.po.MStore;
import cn.scau.edu.ssm.movietalk.po.MStoreVO;

/**
 * 用户影片收藏表
 * @author Administrator
 *
 */
public interface MStoreService {
	public boolean isCollect(int uid, int mid) throws Exception;
	public int addCollect(MStore store) throws Exception;
	public int cancelCollect(MStore store) throws Exception;
	public MStoreVO queryStore(int page, int size, int uid) throws Exception;
}
