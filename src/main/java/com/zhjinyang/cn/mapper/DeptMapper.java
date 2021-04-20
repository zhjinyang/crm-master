package com.zhjinyang.cn.mapper;

import com.zhjinyang.cn.domin.entity.Dept;
import com.zhjinyang.cn.mapper.base.MyMapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Zjy
 * @date 2021/4/14 23:01
 */
public interface DeptMapper extends MyMapper<Dept> {

    /**
     * 查询是否有孩子
     */
    @Select("select count(1) from base_dept where parent_id=#{id}")
    int getChildrenCount(Long id);
}
