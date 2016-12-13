package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MReviewAnti;
import cn.scau.edu.ssm.movietalk.po.MReviewAntiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MReviewAntiMapper {
    int countByExample(MReviewAntiExample example);

    int deleteByExample(MReviewAntiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MReviewAnti record);

    int insertSelective(MReviewAnti record);

    List<MReviewAnti> selectByExampleWithBLOBs(MReviewAntiExample example);

    List<MReviewAnti> selectByExample(MReviewAntiExample example);

    MReviewAnti selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MReviewAnti record, @Param("example") MReviewAntiExample example);

    int updateByExampleWithBLOBs(@Param("record") MReviewAnti record, @Param("example") MReviewAntiExample example);

    int updateByExample(@Param("record") MReviewAnti record, @Param("example") MReviewAntiExample example);

    int updateByPrimaryKeySelective(MReviewAnti record);

    int updateByPrimaryKeyWithBLOBs(MReviewAnti record);

    int updateByPrimaryKey(MReviewAnti record);
}