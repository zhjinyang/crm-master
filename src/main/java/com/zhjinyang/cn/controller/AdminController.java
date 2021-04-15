package com.zhjinyang.cn.controller;

import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.entity.Admin;
import com.zhjinyang.cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/15 19:50
 */
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public AxiosResult<List<Admin>> findAll(){
        List<Admin> all = adminService.findAll();
        return AxiosResult.success(all);
    }

    @GetMapping("{id}")
    public AxiosResult<Admin> findById(@PathVariable Long id) {
        return AxiosResult.success(adminService.findById(id));
    }


    @PostMapping
    public AxiosResult<Void> add(@RequestBody Admin admin) {
        return toAxios(adminService.add(admin));
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Admin admin) {
        return toAxios(adminService.update(admin));
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id) {
        return toAxios(adminService.deleteById(id));
    }
}
