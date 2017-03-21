package cn.scau.edu.ssm.movietalk.mapper;

import java.util.List;

import cn.scau.edu.ssm.movietalk.po.MReviewReplyExt;

public interface MReviewReplyExtMapper {
    List<MReviewReplyExt> selectByLid(int lid);
}