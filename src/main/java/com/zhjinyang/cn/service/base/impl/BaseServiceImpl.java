package com.zhjinyang.cn.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zhjinyang.cn.mapper.base.MyMapper;
import com.zhjinyang.cn.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/14 22:36
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private MyMapper<T> myMapper;


    protected MyMapper<T> getMyMapper(){
        return myMapper;
    }

    @Override
    public List<T> findAll() {
        return myMapper.selectList(null);
    }

    @Override
    public List<T> search(Wrapper<T> wrapper) {
        return myMapper.selectList(wrapper);
    }

    @Override
    public T findById(Long id) {
        return myMapper.selectById(id);
    }

    @Override
    public int add(T t) {
        return myMapper.insert(t);
    }

    @Override
    public int update(T t) {
        return myMapper.updateById(t);
    }

    @Override
    public int deleteById(Long id) {
        return myMapper.deleteById(id);
    }

    @Transactional
    @Override
    public int batchDeleteByIds(List<Long> ids) {
        return myMapper.deleteBatchIds(ids);
    }
}
