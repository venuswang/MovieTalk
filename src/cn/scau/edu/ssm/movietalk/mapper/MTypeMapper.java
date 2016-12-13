package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MType;
import cn.scau.edu.ssm.movietalk.po.MTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MTypeMapper {
    int countByExample(MTypeExample example);

    int deleteByExample(MTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MType record);

    int insertSelective(MType record);

    List<MType> selectByExample(MTypeExample example);

    MType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MType record, @Param("example") MTypeExample example);

    int updateByExample(@Param("record") MType record, @Param("example") MTypeExample example);

    int updateByPrimaryKeySelective(MType record);

    int updateByPrimaryKey(MType record);
}