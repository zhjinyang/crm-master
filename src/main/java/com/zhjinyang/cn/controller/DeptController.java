package com.zhjinyang.cn.controller;

import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.entity.Dept;
import com.zhjinyang.cn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/15 19:20
 */
@RestController
@RequestMapping("dept")
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public AxiosResult<List<Dept>> findAll() {
        return AxiosResult.success(deptService.findAll());
    }

    @GetMapping("{id}")
    public AxiosResult<Dept> findById(@PathVariable Long id) {
        return AxiosResult.success(deptService.findById(id));
    }


    @PostMapping
    public AxiosResult<Void> add(@RequestBody Dept dept) {
        return toAxios(deptService.add(dept));
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Dept dept) {
        return toAxios(deptService.update(dept));
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id) {
        return toAxios(deptService.deleteById(id));
    }


}
