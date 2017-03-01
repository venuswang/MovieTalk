package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MActorExt;
import cn.scau.edu.ssm.movietalk.po.MTag;

import java.util.List;

public interface MActorExtMapper {
    public List<MActorExt> selectByActorName(String actorName);
    public List<MActorExt> selectAll();
    public int insertActor(MActorExt mActorExt);
}