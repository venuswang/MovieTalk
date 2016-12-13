package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MFilmpic;
import cn.scau.edu.ssm.movietalk.po.MFilmpicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MFilmpicMapper {
    int countByExample(MFilmpicExample example);

    int deleteByExample(MFilmpicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MFilmpic record);

    int insertSelective(MFilmpic record);

    List<MFilmpic> selectByExample(MFilmpicExample example);

    MFilmpic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MFilmpic record, @Param("example") MFilmpicExample example);

    int updateByExample(@Param("record") MFilmpic record, @Param("example") MFilmpicExample example);

    int updateByPrimaryKeySelective(MFilmpic record);

    int updateByPrimaryKey(MFilmpic record);
}