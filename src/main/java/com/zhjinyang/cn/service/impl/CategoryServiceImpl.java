package com.zhjinyang.cn.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.common.utils.TreeUtils;
import com.zhjinyang.cn.domin.criteria.CategoryCriteria;
import com.zhjinyang.cn.domin.entity.Category;
import com.zhjinyang.cn.domin.vo.CategoryVo;
import com.zhjinyang.cn.mapper.CategoryMapper;
import com.zhjinyang.cn.service.CategoryService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import com.zhjinyang.cn.transfer.CategoryTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/14 23:18
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    private final CategoryTransfer categoryTransfer;
    private final CategoryMapper categoryMapper;
    private final StringRedisTemplate redisTemplate;

    @Override
    public List<CategoryVo> buildTree() {
        List<Category> list = this.findAll();
        List<CategoryVo> categoryVos = categoryTransfer.toVO(list);

        String str = redisTemplate.opsForValue().get("categoryVoListStr");
        if (str==null || str == ""){
            List<CategoryVo> categoryVos1 = TreeUtils.buildTree(categoryVos);
            String string = JSON.toJSONString(categoryVos1);
            redisTemplate.opsForValue().set("categoryVoListStr",string);
            return categoryVos1;
        }
        String categoryVoListStr1 = redisTemplate.opsForValue().get("categoryVoListStr");
        List<CategoryVo> categoryVoListStr = JSON.parseArray(categoryVoListStr1, CategoryVo.class);


        return categoryVoListStr;
    }

    //添加分类
    @Override
    public int addCategory(Category category) {
        int insert = categoryMapper.insert(category);
        return insert;
    }


   /* @Override
    public PageResult<CategoryVo> buildTreeByPage(CategoryCriteria categoryCriteria) {
        PageHelper.startPage(categoryCriteria.getCurrentPage(),categoryCriteria.getPageSize());
        List<Category> categories = categoryMapper.selectList(new QueryWrapper<Category>().lambda().eq(Category::getParentId, (long) 0));

        PageInfo<Category> categoryPageInfo = new PageInfo<>(categories);
        long total = categoryPageInfo.getTotal();
        System.out.println(total+"==========");

        List<Category> all = this.findAll();
        List<CategoryVo> categoryVos = categoryTransfer.toVO(all);
        List<CategoryVo> categoryVos1 = TreeUtils.buildTree(categoryVos);

        PageResult<CategoryVo> categoryVoPageResult = new PageResult<>(total, categoryVos1);


        return categoryVoPageResult;
    }*/


}
