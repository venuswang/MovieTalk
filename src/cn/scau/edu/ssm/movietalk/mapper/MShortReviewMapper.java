package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MShortReview;
import cn.scau.edu.ssm.movietalk.po.MShortReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MShortReviewMapper {
    int countByExample(MShortReviewExample example);

    int deleteByExample(MShortReviewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MShortReview record);

    int insertSelective(MShortReview record);

    List<MShortReview> selectByExampleWithBLOBs(MShortReviewExample example);

    List<MShortReview> selectByExample(MShortReviewExample example);

    MShortReview selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MShortReview record, @Param("example") MShortReviewExample example);

    int updateByExampleWithBLOBs(@Param("record") MShortReview record, @Param("example") MShortReviewExample example);

    int updateByExample(@Param("record") MShortReview record, @Param("example") MShortReviewExample example);

    int updateByPrimaryKeySelective(MShortReview record);

    int updateByPrimaryKeyWithBLOBs(MShortReview record);

    int updateByPrimaryKey(MShortReview record);
}