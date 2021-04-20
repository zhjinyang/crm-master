package com.zhjinyang.cn.service;

import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.domin.criteria.CategoryCriteria;
import com.zhjinyang.cn.domin.entity.Category;
import com.zhjinyang.cn.domin.vo.CategoryVo;
import com.zhjinyang.cn.service.base.BaseService;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/14 23:17
 */
public interface CategoryService extends BaseService<Category> {


    /**
     * 展示所有分类的树形结构
     * @return
     */
    List<CategoryVo> buildTree();

    int addCategory(Category category);


    //PageResult<CategoryVo> buildTreeByPage(CategoryCriteria categoryCriteria);

}
