package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.exception.MyException;
import cn.scau.edu.ssm.movietalk.mapper.MFilmpicMapper;
import cn.scau.edu.ssm.movietalk.mapper.MListExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MListMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMactorExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMactorMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMtagExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMtagMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMtypeExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMtypeMapper;
import cn.scau.edu.ssm.movietalk.po.MFilmpic;
import cn.scau.edu.ssm.movietalk.po.MListExample;
import cn.scau.edu.ssm.movietalk.po.MListExample.Criteria;
import cn.scau.edu.ssm.movietalk.po.MListExt;
import cn.scau.edu.ssm.movietalk.po.MMactor;
import cn.scau.edu.ssm.movietalk.po.MMtag;
import cn.scau.edu.ssm.movietalk.po.MMtype;
import cn.scau.edu.ssm.movietalk.service.MListService;

/**
 *  影片的service的实现类
 * @author Administrator
 *
 */
public class MListServiceImpl implements MListService {
	@Autowired
	private MListMapper mListMapper;
	@Autowired
	private MListExtMapper mListExtMapper;
	@Autowired
	private MMactorMapper mMactorMapper;
	@Autowired
	private MMactorExtMapper mMactorExtMapper;
	@Autowired
	private MMtypeMapper mMtypeMapper;
	@Autowired
	private MMtypeExtMapper mMtypeExtMapper;
	@Autowired
	private MMtagMapper mMtagMapper;
	@Autowired
	private MMtagExtMapper mMtagExtMapper;
	@Autowired
	private MFilmpicMapper mFilmpicMapper;
	
	
	@Override
	public int countMlist() throws Exception {
		byte sign = (byte)0;
		MListExample example = new MListExample();
		Criteria criteria = example.createCriteria();
		criteria.andMtypeEqualTo(sign).andStatusEqualTo(sign);
		int count = mListMapper.countByExample(example);
		return count;
	}

	@Override
	public int insertMlist(MListExt mlist) throws Exception {
		int result = mListExtMapper.insertSelectiveExt(mlist);
		if(result > 0) {
			return mlist.getId();
		}
		throw new MyException("插入电影信息失败");
	}

	@Override
	public void insertFilPic(MFilmpic filmPic) throws Exception {
		mFilmpicMapper.insertSelective(filmPic);
	}

	@Override
	public void insertFilTag(MMtag filmTag) throws Exception {
		mMtagMapper.insertSelective(filmTag);
	}

	@Override
	public void insertFilType(List<MMtype> filmType) throws Exception {
		mMtypeExtMapper.insertBatch(filmType);
	}

	@Override
	public void insertfilActor(List<MMactor> filmActor) throws Exception {
		mMactorExtMapper.insertBatch(filmActor);
	}

	@Override
	public MListExt queryList(Integer listId) throws Exception {
		// 获取基本资料
		MListExt list = mListExtMapper.selectByListId(listId);
		// 获取标签
		list.setTagid(String.valueOf(mMtagExtMapper.getTagByMid(listId)));
		// 获取类型
		list.setTypeList(mMtypeExtMapper.getTypeByMid(listId));
		// 获取演员
		list.setActorList(mMactorExtMapper.getActorByMid(listId));
		return list;
	}

	@Override
	public void updateMlist(MListExt mlist) throws Exception {
		mListMapper.updateByPrimaryKeySelective(mlist);
	}

	@Override
	public void updateFilTag(MMtag filmTag) throws Exception {
		mMtagExtMapper.updateTagByMid(filmTag);
	}

	@Override
	public void updateFilType(List<MMtype> filmType) throws Exception {
		if(filmType != null && filmType.size() > 0) {
			int mid = filmType.get(0).getMid();
			mMtypeExtMapper.deleteTypeByMid(mid);
			mMtypeExtMapper.insertBatch(filmType);
		}
	}

	@Override
	public void updatefilActor(List<MMactor> filmActor) throws Exception {
		if(filmActor != null && filmActor.size() > 0) {
			int mid = filmActor.get(0).getMid();
			mMactorExtMapper.deleteActorByMid(mid);
			mMactorExtMapper.insertBatch(filmActor);
		}
	}

	@Override
	public void deleteList(int mid) throws Exception {
		
		// 删除电影图片
		cn.scau.edu.ssm.movietalk.po.MFilmpicExample example = new cn.scau.edu.ssm.movietalk.po.MFilmpicExample();
		cn.scau.edu.ssm.movietalk.po.MFilmpicExample.Criteria criteria = example.createCriteria();
		criteria.andMidEqualTo(mid);
		mFilmpicMapper.deleteByExample(example);
		// 删除电影标签
		mMtagExtMapper.deleteTagByMid(mid);
		// 删除电影类型
		mMtypeExtMapper.deleteTypeByMid(mid);
		// 删除电影演员
		mMactorExtMapper.deleteActorByMid(mid);
		// 删除电影
		mListMapper.deleteByPrimaryKey(mid);
	}

}
