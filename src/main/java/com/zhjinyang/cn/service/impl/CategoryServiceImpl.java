package com.zhjinyang.cn.service.impl;

import com.zhjinyang.cn.domin.entity.Category;
import com.zhjinyang.cn.service.CategoryService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zjy
 * @date 2021/4/14 23:18
 */
@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
}
