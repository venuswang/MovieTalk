package cn.scau.edu.ssm.movietalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.edu.ssm.movietalk.exception.MyException;
import cn.scau.edu.ssm.movietalk.mapper.MFilmpicMapper;
import cn.scau.edu.ssm.movietalk.mapper.MListExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MListMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMactorExtMapper;
import cn.scau.edu.ssm.movietalk.mapper.MMactorMapper;
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

}
