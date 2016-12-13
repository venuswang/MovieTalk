package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MTag;
import cn.scau.edu.ssm.movietalk.po.MTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MTagMapper {
    int countByExample(MTagExample example);

    int deleteByExample(MTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MTag record);

    int insertSelective(MTag record);

    List<MTag> selectByExample(MTagExample example);

    MTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MTag record, @Param("example") MTagExample example);

    int updateByExample(@Param("record") MTag record, @Param("example") MTagExample example);

    int updateByPrimaryKeySelective(MTag record);

    int updateByPrimaryKey(MTag record);
}