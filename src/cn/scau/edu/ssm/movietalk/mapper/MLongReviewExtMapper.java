package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MLongReviewExt;
import java.util.List;


public interface MLongReviewExtMapper {
    List<MLongReviewExt> selectByMid(int mid);
    List<MLongReviewExt> selectAllReview();
    MLongReviewExt selectById(int id);
    int addLongSuppose(int id);
    int cancelLongSuppose(int id);
    int addLongAnti(int id);
    int cancelLongAnti(int id);
}