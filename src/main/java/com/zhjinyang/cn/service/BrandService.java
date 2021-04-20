package com.zhjinyang.cn.service;

import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.domin.criteria.BrandCriteria;
import com.zhjinyang.cn.domin.entity.Brand;
import com.zhjinyang.cn.domin.vo.BrandVo;
import com.zhjinyang.cn.service.base.BaseService;


/**
 * @author Zjy
 * @date 2021/4/14 23:07
 */
public interface BrandService extends BaseService<Brand> {
    PageResult<BrandVo> searchPage(BrandCriteria brandCriteria);

    BrandVo findByVoId(Long id);
}
