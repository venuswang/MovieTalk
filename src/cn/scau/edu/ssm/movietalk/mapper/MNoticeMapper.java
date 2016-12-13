package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MNotice;
import cn.scau.edu.ssm.movietalk.po.MNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MNoticeMapper {
    int countByExample(MNoticeExample example);

    int deleteByExample(MNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MNotice record);

    int insertSelective(MNotice record);

    List<MNotice> selectByExampleWithBLOBs(MNoticeExample example);

    List<MNotice> selectByExample(MNoticeExample example);

    MNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MNotice record, @Param("example") MNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") MNotice record, @Param("example") MNoticeExample example);

    int updateByExample(@Param("record") MNotice record, @Param("example") MNoticeExample example);

    int updateByPrimaryKeySelective(MNotice record);

    int updateByPrimaryKeyWithBLOBs(MNotice record);

    int updateByPrimaryKey(MNotice record);
}