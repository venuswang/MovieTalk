package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MRole;
import cn.scau.edu.ssm.movietalk.po.MRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MRoleMapper {
    int countByExample(MRoleExample example);

    int deleteByExample(MRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MRole record);

    int insertSelective(MRole record);

    List<MRole> selectByExample(MRoleExample example);

    MRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MRole record, @Param("example") MRoleExample example);

    int updateByExample(@Param("record") MRole record, @Param("example") MRoleExample example);

    int updateByPrimaryKeySelective(MRole record);

    int updateByPrimaryKey(MRole record);
}