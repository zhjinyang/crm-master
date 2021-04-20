package com.zhjinyang.cn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.criteria.BrandCriteria;
import com.zhjinyang.cn.domin.entity.Brand;
import com.zhjinyang.cn.domin.vo.BrandVo;
import com.zhjinyang.cn.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/15 19:20
 */
@RestController
@RequestMapping("brand")
@RequiredArgsConstructor
public class BrandController extends BaseController {

    private final BrandService brandService;

    /**
     * 分页条件查询
     *
     * @param brandCriteria
     * @return
     */
    @GetMapping
    public AxiosResult<PageResult<BrandVo>> findAll(BrandCriteria brandCriteria) {
        PageResult<BrandVo> brandVoPageResult = brandService.searchPage(brandCriteria);
        return AxiosResult.success(brandVoPageResult);
    }

    @GetMapping("{id}")
    public AxiosResult<BrandVo> findById(@PathVariable Long id) {
        BrandVo brandVo = brandService.findByVoId(id);
        return AxiosResult.success(brandVo);
    }


    @PostMapping
    public AxiosResult<Void> add(@RequestBody Brand brand) {
        return toAxios(brandService.add(brand));
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Brand brand) {
        return toAxios(brandService.update(brand));
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id) {
        return toAxios(brandService.deleteById(id));
    }

    @DeleteMapping("batch/{ids}")
    public AxiosResult<Void> deleteBatch(@PathVariable List<Long> ids) {
        return toAxios(brandService.batchDeleteByIds(ids));
    }


}
