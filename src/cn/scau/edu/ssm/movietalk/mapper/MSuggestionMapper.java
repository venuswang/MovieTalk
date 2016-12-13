package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MSuggestion;
import cn.scau.edu.ssm.movietalk.po.MSuggestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MSuggestionMapper {
    int countByExample(MSuggestionExample example);

    int deleteByExample(MSuggestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MSuggestion record);

    int insertSelective(MSuggestion record);

    List<MSuggestion> selectByExampleWithBLOBs(MSuggestionExample example);

    List<MSuggestion> selectByExample(MSuggestionExample example);

    MSuggestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MSuggestion record, @Param("example") MSuggestionExample example);

    int updateByExampleWithBLOBs(@Param("record") MSuggestion record, @Param("example") MSuggestionExample example);

    int updateByExample(@Param("record") MSuggestion record, @Param("example") MSuggestionExample example);

    int updateByPrimaryKeySelective(MSuggestion record);

    int updateByPrimaryKeyWithBLOBs(MSuggestion record);

    int updateByPrimaryKey(MSuggestion record);
}