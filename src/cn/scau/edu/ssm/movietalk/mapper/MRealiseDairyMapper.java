package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MRealiseDairy;
import cn.scau.edu.ssm.movietalk.po.MRealiseDairyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MRealiseDairyMapper {
    int countByExample(MRealiseDairyExample example);

    int deleteByExample(MRealiseDairyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MRealiseDairy record);

    int insertSelective(MRealiseDairy record);

    List<MRealiseDairy> selectByExample(MRealiseDairyExample example);

    MRealiseDairy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MRealiseDairy record, @Param("example") MRealiseDairyExample example);

    int updateByExample(@Param("record") MRealiseDairy record, @Param("example") MRealiseDairyExample example);

    int updateByPrimaryKeySelective(MRealiseDairy record);

    int updateByPrimaryKey(MRealiseDairy record);
}