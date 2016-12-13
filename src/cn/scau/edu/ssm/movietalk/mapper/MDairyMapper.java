package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MDairy;
import cn.scau.edu.ssm.movietalk.po.MDairyExample;
import cn.scau.edu.ssm.movietalk.po.MDairyWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MDairyMapper {
    int countByExample(MDairyExample example);

    int deleteByExample(MDairyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MDairyWithBLOBs record);

    int insertSelective(MDairyWithBLOBs record);

    List<MDairyWithBLOBs> selectByExampleWithBLOBs(MDairyExample example);

    List<MDairy> selectByExample(MDairyExample example);

    MDairyWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MDairyWithBLOBs record, @Param("example") MDairyExample example);

    int updateByExampleWithBLOBs(@Param("record") MDairyWithBLOBs record, @Param("example") MDairyExample example);

    int updateByExample(@Param("record") MDairy record, @Param("example") MDairyExample example);

    int updateByPrimaryKeySelective(MDairyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MDairyWithBLOBs record);

    int updateByPrimaryKey(MDairy record);
}