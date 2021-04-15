package com.zhjinyang.cn.service.impl;

import com.zhjinyang.cn.domin.entity.Brand;
import com.zhjinyang.cn.service.BrandService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zjy
 * @date 2021/4/14 23:11
 */
@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {

}
