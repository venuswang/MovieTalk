package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MMtype;
import cn.scau.edu.ssm.movietalk.po.MMtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MMtypeMapper {
    int countByExample(MMtypeExample example);

    int deleteByExample(MMtypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MMtype record);

    int insertSelective(MMtype record);

    List<MMtype> selectByExample(MMtypeExample example);

    MMtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MMtype record, @Param("example") MMtypeExample example);

    int updateByExample(@Param("record") MMtype record, @Param("example") MMtypeExample example);

    int updateByPrimaryKeySelective(MMtype record);

    int updateByPrimaryKey(MMtype record);
}