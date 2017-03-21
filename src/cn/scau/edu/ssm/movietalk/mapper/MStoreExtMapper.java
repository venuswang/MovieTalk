package cn.scau.edu.ssm.movietalk.mapper;

import java.util.List;

import cn.scau.edu.ssm.movietalk.po.MStoreExt;

public interface MStoreExtMapper {

    List<MStoreExt> selectALLByUid(int uid);

}