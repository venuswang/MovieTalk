package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MMtag;
import cn.scau.edu.ssm.movietalk.po.MMtagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MMtagMapper {
    int countByExample(MMtagExample example);

    int deleteByExample(MMtagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MMtag record);

    int insertSelective(MMtag record);

    List<MMtag> selectByExample(MMtagExample example);

    MMtag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MMtag record, @Param("example") MMtagExample example);

    int updateByExample(@Param("record") MMtag record, @Param("example") MMtagExample example);

    int updateByPrimaryKeySelective(MMtag record);

    int updateByPrimaryKey(MMtag record);
}