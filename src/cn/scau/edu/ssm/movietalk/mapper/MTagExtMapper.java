package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MTag;
import cn.scau.edu.ssm.movietalk.po.MTagExt;

import java.util.List;

public interface MTagExtMapper {
    public List<MTag> selectByTagName(String tagName);
    public List<MTag> selectAll();
    public List<MTagExt> selectAllTag();
}