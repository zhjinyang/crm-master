package com.zhjinyang.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.domin.criteria.BrandCriteria;
import com.zhjinyang.cn.domin.entity.Brand;
import com.zhjinyang.cn.domin.vo.BrandVo;
import com.zhjinyang.cn.mapper.BrandMapper;
import com.zhjinyang.cn.service.BrandService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import com.zhjinyang.cn.transfer.BrandTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/14 23:11
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {

    private final BrandMapper brandMapper;

    private final BrandTransfer brandTransfer;


    @Override
    public PageResult<BrandVo> searchPage(BrandCriteria brandCriteria) {
        //开启分页
        PageHelper.startPage(brandCriteria.getCurrentPage(), brandCriteria.getPageSize());
        LambdaQueryWrapper<Brand> lambda = new QueryWrapper<Brand>().lambda();

        if (!StringUtils.isEmpty(brandCriteria.getBrandName())) {
            lambda.like(Brand::getBrandName, brandCriteria.getBrandName());
        }
        LocalDateTime startTime = brandCriteria.getStartTime();
        LocalDateTime endTime = brandCriteria.getEndTime();
        if (startTime != null && endTime != null) {
            lambda.between(Brand::getCreateTime, startTime, endTime);

        }
        List<Brand> brands = brandMapper.selectList(lambda);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        long total = pageInfo.getTotal();

        List<BrandVo> brandVos = brandTransfer.toVO(brands);


        PageResult<BrandVo> brandPageResult = new PageResult<>(total, brandVos);

        /*ArrayList<BrandVo> list = new ArrayList<>();
        brands.forEach(brand -> {
            BrandVo brandVo = new BrandVo();
            BeanUtils.copyProperties(brand,brandVo);
            list.add(brandVo);
        });*/

        return brandPageResult;
    }

    @Override
    public BrandVo findByVoId(Long id) {
        Brand brand = findById(id);
        BrandVo brandVo = brandTransfer.toVO(brand);
        return brandVo;
    }
}
