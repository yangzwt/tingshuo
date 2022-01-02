package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 13:23
 **/
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {
    /**
     * 岗位信息查询操作
     * @param sysPost
     * @return
     */
    List<SysPost> selectPostList(SysPost sysPost);
}
