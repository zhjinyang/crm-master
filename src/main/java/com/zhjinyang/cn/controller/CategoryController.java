package com.zhjinyang.cn.controller;

import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.entity.Category;
import com.zhjinyang.cn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/15 19:20
 */
@RestController
@RequestMapping("category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public AxiosResult<List<Category>> findAll() {
        return AxiosResult.success(categoryService.findAll());
    }

    @GetMapping("{id}")
    public AxiosResult<Category> findById(@PathVariable Long id) {
        return AxiosResult.success(categoryService.findById(id));
    }


    @PostMapping
    public AxiosResult<Void> add(@RequestBody Category category) {
        return toAxios(categoryService.add(category));
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Category category) {
        return toAxios(categoryService.update(category));
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id) {
        return toAxios(categoryService.deleteById(id));
    }


}
