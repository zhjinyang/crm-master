package com.zhjinyang.cn.service.impl;

import com.zhjinyang.cn.domin.entity.Dept;
import com.zhjinyang.cn.service.DeptService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zjy
 * @date 2021/4/14 23:16
 */
@Service
@Transactional
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {
}
