package cn.scau.edu.ssm.movietalk.service;

import java.util.List;

import cn.scau.edu.ssm.movietalk.po.MFilmpic;
import cn.scau.edu.ssm.movietalk.po.MListExt;
import cn.scau.edu.ssm.movietalk.po.MMactor;
import cn.scau.edu.ssm.movietalk.po.MMtag;
import cn.scau.edu.ssm.movietalk.po.MMtype;

/**
 * 影片的service
 * @author Administrator
 *
 */
public interface MListService {
	public int countMlist() throws Exception;
	public int insertMlist(MListExt mlist) throws Exception;
	public void updateMlist(MListExt mlist) throws Exception;
	public void insertFilPic(MFilmpic filmPic) throws Exception;
	public void insertFilTag(MMtag filmTag) throws Exception;
	public void updateFilTag(MMtag filmTag) throws Exception;
	public void insertFilType(List<MMtype> filmType) throws Exception;
	public void updateFilType(List<MMtype> filmType) throws Exception;
	public void insertfilActor(List<MMactor> filmActor) throws Exception;
	public void updatefilActor(List<MMactor> filmActor) throws Exception;
	public MListExt queryList(Integer listId) throws Exception;
	public void deleteList(int mid) throws Exception;
}
