package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MStore;
import cn.scau.edu.ssm.movietalk.po.MStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MStoreMapper {
    int countByExample(MStoreExample example);

    int deleteByExample(MStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MStore record);

    int insertSelective(MStore record);

    List<MStore> selectByExample(MStoreExample example);

    MStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MStore record, @Param("example") MStoreExample example);

    int updateByExample(@Param("record") MStore record, @Param("example") MStoreExample example);

    int updateByPrimaryKeySelective(MStore record);

    int updateByPrimaryKey(MStore record);
}