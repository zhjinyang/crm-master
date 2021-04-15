package com.zhjinyang.cn.controller;

import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.entity.Brand;
import com.zhjinyang.cn.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public AxiosResult<List<Brand>> findAll() {
        return AxiosResult.success(brandService.findAll());
    }

    @GetMapping("{id}")
    public AxiosResult<Brand> findById(@PathVariable Long id) {
        return AxiosResult.success(brandService.findById(id));
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


}
