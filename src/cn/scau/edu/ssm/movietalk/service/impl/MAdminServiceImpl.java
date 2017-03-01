package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.mapper.MActorExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MActorMapper;
import cn.scau.edu.ssm.movietalk.mapper.MAdminExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MAdminMapper;
import cn.scau.edu.ssm.movietalk.mapper.MListExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MListMapper;
import cn.scau.edu.ssm.movietalk.mapper.MPicactorMapper;
import cn.scau.edu.ssm.movietalk.mapper.MTagExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MTagMapper;
import cn.scau.edu.ssm.movietalk.mapper.MTypeExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MTypeMapper;
import cn.scau.edu.ssm.movietalk.po.MActor;
import cn.scau.edu.ssm.movietalk.po.MActorExt;
import cn.scau.edu.ssm.movietalk.po.MActorVO;
import cn.scau.edu.ssm.movietalk.po.MAdmin;
import cn.scau.edu.ssm.movietalk.po.MAdminExample;
import cn.scau.edu.ssm.movietalk.po.MAdminExample.Criteria;
import cn.scau.edu.ssm.movietalk.po.MAdminExtend;
import cn.scau.edu.ssm.movietalk.po.MListExt;
import cn.scau.edu.ssm.movietalk.po.MListVO;
import cn.scau.edu.ssm.movietalk.po.MPicactor;
import cn.scau.edu.ssm.movietalk.po.MTag;
import cn.scau.edu.ssm.movietalk.po.MTagExample;
import cn.scau.edu.ssm.movietalk.po.MType;
import cn.scau.edu.ssm.movietalk.po.MTypeExample;
import cn.scau.edu.ssm.movietalk.po.MyResult;
import cn.scau.edu.ssm.movietalk.po.TagVO;
import cn.scau.edu.ssm.movietalk.po.TypeVO;
import cn.scau.edu.ssm.movietalk.service.MAdminService;

public class MAdminServiceImpl implements MAdminService {
	@Autowired
	private MAdminMapper mAdminMapper;
	@Autowired
	private MAdminExtMapper mAdminExtMapper;
	@Autowired
	private MTagMapper mTagMapper;
	@Autowired
	private MTagExtMapper mTagExtMapper;
	@Autowired
	private MTypeExtMapper mTypeExtMapper;
	@Autowired
	private MTypeMapper mTypeMapper;
	@Autowired 
	private MActorExtMapper mActorExtMapper;
	@Autowired
	private MActorMapper mActorMapper;
	@Autowired
	private MPicactorMapper mPicactorMapper;
	@Autowired
	private MListMapper mListMapper;
	@Autowired
	private MListExtMapper mListExtMapper;
	
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

	@Override
	public int countMadmin() throws Exception {
		MAdminExample mAdminExample = new MAdminExample();
		Criteria criteria = mAdminExample.createCriteria();
		criteria.andStatusEqualTo(true);
		int count = mAdminMapper.countByExample(mAdminExample);
		return count;
	}

	@Override
	public MAdmin getAdmin(String username) throws Exception {
		MAdminExample mAdminExample = new MAdminExample();
		Criteria criteria = mAdminExample.createCriteria();
		criteria.andUnameEqualTo(username).andStatusEqualTo(true);
		List<MAdmin> admins = mAdminMapper.selectByExample(mAdminExample);
		MAdmin admin = admins.get(0);
		return admin;
	}

	@Override
	public MyResult updateAdmin(MAdminExtend mAdminExtend) throws Exception {
		MyResult myResult = new MyResult();
		int result = mAdminMapper.updateByPrimaryKeySelective(mAdminExtend);
		if(result == 1) {
			myResult.setMessage("更新成功");
			myResult.setResult(true);
		} else {
			myResult.setMessage("更新失败");
			myResult.setResult(false);
		}
		return myResult;
	}

	@Override
	public int getAdminIdByUserPassword(String username, String password)
			throws Exception {
		MAdminExample mAdminExample = new MAdminExample();
		Criteria criteria = mAdminExample.createCriteria();
		criteria.andUnameEqualTo(username).andPwordEqualTo(password).andStatusEqualTo(true);
		List<MAdmin> admins = mAdminMapper.selectByExample(mAdminExample);
		if(admins.size() == 0) {
			return -1;
		}
		MAdmin admin = admins.get(0);
		return admin.getId();
	}

	@Override
	public int updateAdminByName(MAdminExtend mAdminExtend) throws Exception {
		int result = mAdminExtMapper.updateByUnameSelective(mAdminExtend);
		return result;
	}

	@Override
	public TagVO queryTag(int page, int size, String tagName) throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		TagVO tagVO = new TagVO();
		List<MTag> mTags = null;
		if(tagName != null && !tagName.trim().equals("")) {
			tagName = tagName.trim();
			mTags = mTagExtMapper.selectByTagName(tagName);
		} else {
			mTags = mTagExtMapper.selectAll();
		}
		int count = mTags.size();
		if(endPage >= count) {
			endPage = count;
		} else {
			endPage += 1;
		}
		int temp = count / size;
		int pageCount = (temp * size == count ? temp : temp + 1);
		if(pageCount == 0) {
			pageCount = 1;
		}
		tagVO.setCount(count);
		tagVO.setPageCount(pageCount);
		tagVO.setPage(page);
		tagVO.setmTag(mTags.subList(startPage, endPage));
		tagVO.setFilterParam(tagName);
		return tagVO;
	}

	@Override
	public MyResult addTag(String tagName) throws Exception {
		MyResult result = new MyResult();
		cn.scau.edu.ssm.movietalk.po.MTagExample example = new MTagExample();
		cn.scau.edu.ssm.movietalk.po.MTagExample.Criteria critera = example.createCriteria();
		critera.andTagnameEqualTo(tagName);
		int count = mTagMapper.countByExample(example);
		if(count > 0) {
			result.setResult(false);
			result.setMessage("该标签已经存在");
			return result;
		}
		MTag record = new MTag();
		record.setTagname(tagName);
		mTagMapper.insertSelective(record);
		result.setResult(true);
		result.setMessage("添加成功");
		return result;
	}

	@Override
	public MyResult updateTag(MTag mtag) throws Exception {
		MyResult myResult = new MyResult();
		int result = mTagMapper.updateByPrimaryKeySelective(mtag);
		if(result == 1) {
			myResult.setResult(true);
			myResult.setMessage("更新成功");
		} else {
			myResult.setResult(false);
			myResult.setMessage("更新失败");
		}
		return myResult;
	}

	@Override
	public MyResult deleteTag(MTag mtag) throws Exception {
		MyResult myResult = new MyResult();
		int result = mTagMapper.deleteByPrimaryKey(mtag.getId());
		if(result == 1) {
			myResult.setResult(true);
			myResult.setMessage("删除成功");
		} else {
			myResult.setResult(false);
			myResult.setMessage("删除失败");
		}
		return myResult;
	}

	@Override
	public TypeVO queryType(int page, int size, String typeName)
			throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		TypeVO typeVO = new TypeVO();
		List<MType> mTypes = null;
		if(typeName != null && !typeName.trim().equals("")) {
			typeName = typeName.trim();
			mTypes = mTypeExtMapper.selectByTypeName(typeName);
		} else {
			mTypes = mTypeExtMapper.selectAll();
		}
		int count = mTypes.size();
		if(endPage >= count) {
			endPage = count;
		} else {
			endPage += 1;
		}
		int temp = count / size;
		int pageCount = (temp * size == count ? temp : temp + 1);
		if(pageCount == 0) {
			pageCount = 1;
		}
		typeVO.setCount(count);
		typeVO.setPageCount(pageCount);
		typeVO.setPage(page);
		typeVO.setmType(mTypes.subList(startPage, endPage));
		typeVO.setFilterParam(typeName);
		return typeVO;
	}

	@Override
	public MyResult addType(String typeName) throws Exception {
		MyResult result = new MyResult();
		cn.scau.edu.ssm.movietalk.po.MTypeExample example = new MTypeExample();
		cn.scau.edu.ssm.movietalk.po.MTypeExample.Criteria critera = example.createCriteria();
		critera.andTypenameEqualTo(typeName);
		int count = mTypeMapper.countByExample(example);
		if(count > 0) {
			result.setResult(false);
			result.setMessage("该类型已经存在");
			return result;
		}
		MType record = new MType();
		record.setTypename(typeName);
		mTypeMapper.insertSelective(record);
		result.setResult(true);
		result.setMessage("添加成功");
		return result;
	}

	@Override
	public MyResult updateType(MType mtype) throws Exception {
		MyResult myResult = new MyResult();
		int result = mTypeMapper.updateByPrimaryKeySelective(mtype);
		if(result == 1) {
			myResult.setResult(true);
			myResult.setMessage("更新成功");
		} else {
			myResult.setResult(false);
			myResult.setMessage("更新失败");
		}
		return myResult;
	}

	@Override
	public MyResult deleteType(MType mtype) throws Exception {
		MyResult myResult = new MyResult();
		int result = mTypeMapper.deleteByPrimaryKey(mtype.getId());
		if(result == 1) {
			myResult.setResult(true);
			myResult.setMessage("删除成功");
		} else {
			myResult.setResult(false);
			myResult.setMessage("删除失败");
		}
		return myResult;
	}

	@Override
	public MActorVO queryActor(int page, int size, String actorName)
			throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		MActorVO actorVO = new MActorVO();
		List<MActorExt> mActor = null;
		if(actorName != null && !actorName.trim().equals("")) {
			actorName = actorName.trim();
			mActor = mActorExtMapper.selectByActorName(actorName);
		} else {
			mActor = mActorExtMapper.selectAll();
		}
		int count = mActor.size();
		if(endPage >= count) {
			endPage = count;
		} else {
			endPage += 1;
		}
		int temp = count / size;
		int pageCount = (temp * size == count ? temp : temp + 1);
		if(pageCount == 0) {
			pageCount = 1;
		}
		actorVO.setCount(count);
		actorVO.setPageCount(pageCount);
		actorVO.setPage(page);
		actorVO.setmActor(mActor.subList(startPage, endPage));
		actorVO.setFilterParam(actorName);
		return actorVO;
	}

	@Override
	public int addActor(MActorExt mActorExt) throws Exception {
		mActorExtMapper.insertActor(mActorExt);
		return mActorExt.getId();
	}

	@Override
	public int addApicture(MPicactor mPicacotr) throws Exception {
		return mPicactorMapper.insertSelective(mPicacotr);
	}

	@Override
	public int deleteActor(int id) throws Exception {
		return mActorMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteApincture(int id) throws Exception {
		return mPicactorMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateActor(MActorExt mActorExt) throws Exception {
		return mActorMapper.updateByPrimaryKeySelective(mActorExt);
	}

	@Override
	public MListVO queryList(int page, int size, String listName)
			throws Exception {
		int startPage = (page - 1) * size;
		int endPage = startPage + size - 1;
		MListVO listVO = new MListVO();
		List<MListExt> mList = null;
		if(listName != null && !listName.trim().equals("")) {
			listName = listName.trim();
			mList = mListExtMapper.selectByListName(listName);
		} else {
			mList = mListExtMapper.selectAll();
		}
		int count = mList.size();
		if(endPage >= count) {
			endPage = count;
		} else {
			endPage += 1;
		}
		int temp = count / size;
		int pageCount = (temp * size == count ? temp : temp + 1);
		if(pageCount == 0) {
			pageCount = 1;
		}
		listVO.setCount(count);
		listVO.setPageCount(pageCount);
		listVO.setPage(page);
		listVO.setmList(mList.subList(startPage, endPage));
		listVO.setFilterParam(listName);
		return listVO;
	}

	@Override
	public List<Map> query_all_actor() throws Exception {
		cn.scau.edu.ssm.movietalk.po.MActorExample example = new cn.scau.edu.ssm.movietalk.po.MActorExample();
		cn.scau.edu.ssm.movietalk.po.MActorExample.Criteria criteria = example.createCriteria();
		List<MActor> mActors = mActorMapper.selectByExample(example);
		List<Map> actors = new ArrayList<Map>();
		if(mActors.size() > 0) {
			for(MActor actor : mActors) {
				HashMap actorMap = new HashMap();
				actorMap.put("id", actor.getId());
				actorMap.put("text", actor.getCname());
				actors.add(actorMap);
			}
		}
		return actors;
	}

	@Override
	public List<Map> query_all_tag() throws Exception {
		List<Map> tags = new ArrayList<Map>();
		cn.scau.edu.ssm.movietalk.po.MTagExample example = new cn.scau.edu.ssm.movietalk.po.MTagExample();
		cn.scau.edu.ssm.movietalk.po.MTagExample.Criteria criteria = example.createCriteria();
		List<MTag> mtags = mTagMapper.selectByExample(example);
		if(mtags.size() > 0) {
			for(MTag tag : mtags) {
				HashMap actorMap = new HashMap();
				actorMap.put("id", tag.getId());
				actorMap.put("text", tag.getTagname());
				tags.add(actorMap);
			}
		}
		return tags;
	}

	@Override
	public List<Map> query_all_type() throws Exception {
		List<Map> types = new ArrayList<Map>();
		cn.scau.edu.ssm.movietalk.po.MTypeExample example = new cn.scau.edu.ssm.movietalk.po.MTypeExample();
		cn.scau.edu.ssm.movietalk.po.MTypeExample.Criteria criteria = example.createCriteria();
		List<MType> mtypes = mTypeMapper.selectByExample(example);
		if(mtypes.size() > 0) {
			for(MType type : mtypes) {
				HashMap actorMap = new HashMap();
				actorMap.put("id", type.getId());
				actorMap.put("text", type.getTypename());
				types.add(actorMap);
			}
		}
		return types;
	}

}
