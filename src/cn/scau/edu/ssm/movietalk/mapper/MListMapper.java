package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MList;
import cn.scau.edu.ssm.movietalk.po.MListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MListMapper {
    int countByExample(MListExample example);

    int deleteByExample(MListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MList record);

    int insertSelective(MList record);

    List<MList> selectByExampleWithBLOBs(MListExample example);

    List<MList> selectByExample(MListExample example);

    MList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MList record, @Param("example") MListExample example);

    int updateByExampleWithBLOBs(@Param("record") MList record, @Param("example") MListExample example);

    int updateByExample(@Param("record") MList record, @Param("example") MListExample example);

    int updateByPrimaryKeySelective(MList record);

    int updateByPrimaryKeyWithBLOBs(MList record);

    int updateByPrimaryKey(MList record);
}