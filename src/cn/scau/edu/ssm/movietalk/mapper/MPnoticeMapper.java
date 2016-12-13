package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MPnotice;
import cn.scau.edu.ssm.movietalk.po.MPnoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MPnoticeMapper {
    int countByExample(MPnoticeExample example);

    int deleteByExample(MPnoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MPnotice record);

    int insertSelective(MPnotice record);

    List<MPnotice> selectByExample(MPnoticeExample example);

    MPnotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MPnotice record, @Param("example") MPnoticeExample example);

    int updateByExample(@Param("record") MPnotice record, @Param("example") MPnoticeExample example);

    int updateByPrimaryKeySelective(MPnotice record);

    int updateByPrimaryKey(MPnotice record);
}