package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MAttention;
import cn.scau.edu.ssm.movietalk.po.MAttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MAttentionMapper {
    int countByExample(MAttentionExample example);

    int deleteByExample(MAttentionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MAttention record);

    int insertSelective(MAttention record);

    List<MAttention> selectByExample(MAttentionExample example);

    MAttention selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MAttention record, @Param("example") MAttentionExample example);

    int updateByExample(@Param("record") MAttention record, @Param("example") MAttentionExample example);

    int updateByPrimaryKeySelective(MAttention record);

    int updateByPrimaryKey(MAttention record);
}