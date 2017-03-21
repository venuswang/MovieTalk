package cn.scau.edu.ssm.movietalk.mapper;

import java.util.List;

import cn.scau.edu.ssm.movietalk.po.MType;
import cn.scau.edu.ssm.movietalk.po.MTypeExt;

public interface MTypeExtMapper {
    public List<MType> selectByTypeName(String typeName);
    public List<MType> selectAll();
    public List<MTypeExt> selectAllType();
}