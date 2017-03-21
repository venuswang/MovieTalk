package cn.scau.edu.ssm.movietalk.mapper;

import java.util.List;

import cn.scau.edu.ssm.movietalk.po.MListExt;

public interface MListExtMapper {
    public List<MListExt> selectByListName(String listName);
    public List<MListExt> selectAll();
    public List<MListExt> selectAllByTag(int tagid);
    public List<MListExt> selectAllByType(int typeid);
    public int insertSelectiveExt(MListExt mlist);
    public MListExt selectByListId(int id);
}