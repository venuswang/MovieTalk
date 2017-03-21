package cn.scau.edu.ssm.movietalk.service;

import java.util.List;
import java.util.Map;

import cn.scau.edu.ssm.movietalk.po.MActorExt;
import cn.scau.edu.ssm.movietalk.po.MActorVO;
import cn.scau.edu.ssm.movietalk.po.MAdmin;
import cn.scau.edu.ssm.movietalk.po.MAdminExtend;
import cn.scau.edu.ssm.movietalk.po.MListVO;
import cn.scau.edu.ssm.movietalk.po.MPicactor;
import cn.scau.edu.ssm.movietalk.po.MTag;
import cn.scau.edu.ssm.movietalk.po.MType;
import cn.scau.edu.ssm.movietalk.po.MyResult;
import cn.scau.edu.ssm.movietalk.po.TagVO;
import cn.scau.edu.ssm.movietalk.po.TypeVO;

/**
 * 后台管理员操作的service
 * @author Administrator
 *
 */
public interface MAdminService {
	public boolean checkMadmin(MAdminExtend mAdminExtend) throws Exception;
	public int countMadmin() throws Exception;
	public MAdmin getAdmin(String username) throws Exception;
	public MyResult updateAdmin(MAdminExtend mAdminExtend) throws Exception;
	public int getAdminIdByUserPassword(String username, String password) throws Exception;
	public int updateAdminByName(MAdminExtend mAdminExtend) throws Exception;
	public TagVO queryTag(int page, int size, String tagName) throws Exception;
	public TypeVO queryType(int page, int size, String typeName) throws Exception;
	public MActorVO queryActor(int page, int size, String actorName) throws Exception;
	public MListVO queryList(int page, int size, String listName) throws Exception;
	public MListVO queryListByTag(int page, int size, int tagid) throws Exception;
	public MListVO queryListByType(int page, int size, int type) throws Exception;
	public MyResult addTag(String tagName) throws Exception;
	public MyResult addType(String typeName) throws Exception;
	public int addActor(MActorExt mActorExt) throws Exception;
	public int addApicture(MPicactor mPicacotr) throws Exception;
	public MyResult updateTag(MTag mtag) throws Exception;
	public MyResult updateType(MType mtype) throws Exception;
	public int updateActor(MActorExt mActorExt) throws Exception;
	public MyResult deleteTag(MTag mtag) throws Exception;
	public int deleteActor(int id) throws Exception;
	public int deleteApincture(int id) throws Exception;
	public MyResult deleteType(MType mtype) throws Exception;
	public List<Map> query_all_actor() throws Exception;
	public List<Map> query_all_tag() throws Exception;
	public List<Map> query_all_type() throws Exception;
}
