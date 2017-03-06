package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MMactor;
import cn.scau.edu.ssm.movietalk.po.MMactorExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MMactorExtMapper {
    public int insertBatch(List<MMactor> mactors);
    public List<Integer> getActorByMid(int mid);
    public int deleteActorByMid(int mid);
}