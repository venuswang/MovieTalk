package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MLongReview;
import cn.scau.edu.ssm.movietalk.po.MLongReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MLongReviewMapper {
    int countByExample(MLongReviewExample example);

    int deleteByExample(MLongReviewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MLongReview record);

    int insertSelective(MLongReview record);

    List<MLongReview> selectByExampleWithBLOBs(MLongReviewExample example);

    List<MLongReview> selectByExample(MLongReviewExample example);

    MLongReview selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MLongReview record, @Param("example") MLongReviewExample example);

    int updateByExampleWithBLOBs(@Param("record") MLongReview record, @Param("example") MLongReviewExample example);

    int updateByExample(@Param("record") MLongReview record, @Param("example") MLongReviewExample example);

    int updateByPrimaryKeySelective(MLongReview record);

    int updateByPrimaryKeyWithBLOBs(MLongReview record);

    int updateByPrimaryKey(MLongReview record);
}