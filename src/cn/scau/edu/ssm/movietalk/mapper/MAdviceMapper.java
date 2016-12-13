package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MAdvice;
import cn.scau.edu.ssm.movietalk.po.MAdviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MAdviceMapper {
    int countByExample(MAdviceExample example);

    int deleteByExample(MAdviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MAdvice record);

    int insertSelective(MAdvice record);

    List<MAdvice> selectByExample(MAdviceExample example);

    MAdvice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MAdvice record, @Param("example") MAdviceExample example);

    int updateByExample(@Param("record") MAdvice record, @Param("example") MAdviceExample example);

    int updateByPrimaryKeySelective(MAdvice record);

    int updateByPrimaryKey(MAdvice record);
}