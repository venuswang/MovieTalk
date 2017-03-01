package cn.scau.edu.ssm.movietalk.mapper;

import cn.scau.edu.ssm.movietalk.po.MMtype;
import cn.scau.edu.ssm.movietalk.po.MMtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MMtypeExtMapper {
    public int insertBatch(List<MMtype> mtype);
}