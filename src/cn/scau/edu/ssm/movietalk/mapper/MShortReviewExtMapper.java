package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MShortReviewExt;
import java.util.List;

public interface MShortReviewExtMapper {

    List<MShortReviewExt> selectByMid(int mid);
    int addSuppose(int id);
    int cancelSuppose(int id);
}