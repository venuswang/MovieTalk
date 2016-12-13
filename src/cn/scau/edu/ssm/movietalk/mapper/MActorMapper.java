package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MActor;
import cn.scau.edu.ssm.movietalk.po.MActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MActorMapper {
    int countByExample(MActorExample example);

    int deleteByExample(MActorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MActor record);

    int insertSelective(MActor record);

    List<MActor> selectByExample(MActorExample example);

    MActor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MActor record, @Param("example") MActorExample example);

    int updateByExample(@Param("record") MActor record, @Param("example") MActorExample example);

    int updateByPrimaryKeySelective(MActor record);

    int updateByPrimaryKey(MActor record);
}