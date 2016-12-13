package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MReviewReply;
import cn.scau.edu.ssm.movietalk.po.MReviewReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MReviewReplyMapper {
    int countByExample(MReviewReplyExample example);

    int deleteByExample(MReviewReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MReviewReply record);

    int insertSelective(MReviewReply record);

    List<MReviewReply> selectByExampleWithBLOBs(MReviewReplyExample example);

    List<MReviewReply> selectByExample(MReviewReplyExample example);

    MReviewReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MReviewReply record, @Param("example") MReviewReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") MReviewReply record, @Param("example") MReviewReplyExample example);

    int updateByExample(@Param("record") MReviewReply record, @Param("example") MReviewReplyExample example);

    int updateByPrimaryKeySelective(MReviewReply record);

    int updateByPrimaryKeyWithBLOBs(MReviewReply record);

    int updateByPrimaryKey(MReviewReply record);
}