package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MPpt;
import cn.scau.edu.ssm.movietalk.po.MPptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MPptMapper {
    int countByExample(MPptExample example);

    int deleteByExample(MPptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MPpt record);

    int insertSelective(MPpt record);

    List<MPpt> selectByExample(MPptExample example);

    MPpt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MPpt record, @Param("example") MPptExample example);

    int updateByExample(@Param("record") MPpt record, @Param("example") MPptExample example);

    int updateByPrimaryKeySelective(MPpt record);

    int updateByPrimaryKey(MPpt record);
}