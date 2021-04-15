package com.zhjinyang.cn.service.base;


import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/14 22:28
 */
public interface BaseService<T> {

    /**
     * 查询所有
     */
    List<T> findAll();

    /**
     * 条件查询
     */
    List<T> search(Wrapper<T> wrapper);

    /**
     * 根据id查询
     */
    T findById(Long id);

    /**
     * 添加
     */
    int add(T t);

    /**
     * 修改
     */
    int update(T t);

    /**
     * 根据id删除
     */
    int deleteById(Long id);

    /**
     * 批量删除
     */
    int batchDeleteByIds(List<Long> ids);


}
