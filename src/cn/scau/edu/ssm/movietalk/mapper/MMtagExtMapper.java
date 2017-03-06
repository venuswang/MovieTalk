package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MMtag;
import cn.scau.edu.ssm.movietalk.po.MMtagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MMtagExtMapper {
    public int getTagByMid(int mid); 
    public int updateTagByMid(MMtag mtag);
    public int deleteTagByMid(int mid);
}