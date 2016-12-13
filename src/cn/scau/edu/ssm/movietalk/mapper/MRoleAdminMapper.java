package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MRoleAdmin;
import cn.scau.edu.ssm.movietalk.po.MRoleAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MRoleAdminMapper {
    int countByExample(MRoleAdminExample example);

    int deleteByExample(MRoleAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MRoleAdmin record);

    int insertSelective(MRoleAdmin record);

    List<MRoleAdmin> selectByExample(MRoleAdminExample example);

    MRoleAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MRoleAdmin record, @Param("example") MRoleAdminExample example);

    int updateByExample(@Param("record") MRoleAdmin record, @Param("example") MRoleAdminExample example);

    int updateByPrimaryKeySelective(MRoleAdmin record);

    int updateByPrimaryKey(MRoleAdmin record);
}