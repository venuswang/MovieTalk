package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MAccess;
import cn.scau.edu.ssm.movietalk.po.MAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MAccessMapper {
    int countByExample(MAccessExample example);

    int deleteByExample(MAccessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MAccess record);

    int insertSelective(MAccess record);

    List<MAccess> selectByExampleWithBLOBs(MAccessExample example);

    List<MAccess> selectByExample(MAccessExample example);

    MAccess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MAccess record, @Param("example") MAccessExample example);

    int updateByExampleWithBLOBs(@Param("record") MAccess record, @Param("example") MAccessExample example);

    int updateByExample(@Param("record") MAccess record, @Param("example") MAccessExample example);

    int updateByPrimaryKeySelective(MAccess record);

    int updateByPrimaryKeyWithBLOBs(MAccess record);

    int updateByPrimaryKey(MAccess record);
}