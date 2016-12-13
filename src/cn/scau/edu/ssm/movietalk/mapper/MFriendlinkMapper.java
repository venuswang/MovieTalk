package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MFriendlink;
import cn.scau.edu.ssm.movietalk.po.MFriendlinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MFriendlinkMapper {
    int countByExample(MFriendlinkExample example);

    int deleteByExample(MFriendlinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MFriendlink record);

    int insertSelective(MFriendlink record);

    List<MFriendlink> selectByExample(MFriendlinkExample example);

    MFriendlink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MFriendlink record, @Param("example") MFriendlinkExample example);

    int updateByExample(@Param("record") MFriendlink record, @Param("example") MFriendlinkExample example);

    int updateByPrimaryKeySelective(MFriendlink record);

    int updateByPrimaryKey(MFriendlink record);
}