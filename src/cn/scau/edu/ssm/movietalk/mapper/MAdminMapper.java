package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MAdmin;
import cn.scau.edu.ssm.movietalk.po.MAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MAdminMapper {
    int countByExample(MAdminExample example);

    int deleteByExample(MAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MAdmin record);

    int insertSelective(MAdmin record);

    List<MAdmin> selectByExample(MAdminExample example);

    MAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MAdmin record, @Param("example") MAdminExample example);

    int updateByExample(@Param("record") MAdmin record, @Param("example") MAdminExample example);

    int updateByPrimaryKeySelective(MAdmin record);

    int updateByPrimaryKey(MAdmin record);
}