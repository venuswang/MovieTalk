package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MPicactor;
import cn.scau.edu.ssm.movietalk.po.MPicactorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MPicactorMapper {
    int countByExample(MPicactorExample example);

    int deleteByExample(MPicactorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MPicactor record);

    int insertSelective(MPicactor record);

    List<MPicactor> selectByExample(MPicactorExample example);

    MPicactor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MPicactor record, @Param("example") MPicactorExample example);

    int updateByExample(@Param("record") MPicactor record, @Param("example") MPicactorExample example);

    int updateByPrimaryKeySelective(MPicactor record);

    int updateByPrimaryKey(MPicactor record);
}