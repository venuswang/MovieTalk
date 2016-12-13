package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MPmood;
import cn.scau.edu.ssm.movietalk.po.MPmoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MPmoodMapper {
    int countByExample(MPmoodExample example);

    int deleteByExample(MPmoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MPmood record);

    int insertSelective(MPmood record);

    List<MPmood> selectByExample(MPmoodExample example);

    MPmood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MPmood record, @Param("example") MPmoodExample example);

    int updateByExample(@Param("record") MPmood record, @Param("example") MPmoodExample example);

    int updateByPrimaryKeySelective(MPmood record);

    int updateByPrimaryKey(MPmood record);
}