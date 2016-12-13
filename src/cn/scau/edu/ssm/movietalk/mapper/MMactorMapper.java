package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MMactor;
import cn.scau.edu.ssm.movietalk.po.MMactorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MMactorMapper {
    int countByExample(MMactorExample example);

    int deleteByExample(MMactorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MMactor record);

    int insertSelective(MMactor record);

    List<MMactor> selectByExample(MMactorExample example);

    MMactor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MMactor record, @Param("example") MMactorExample example);

    int updateByExample(@Param("record") MMactor record, @Param("example") MMactorExample example);

    int updateByPrimaryKeySelective(MMactor record);

    int updateByPrimaryKey(MMactor record);
}