package com.zhjinyang.cn.controller;

import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.entity.Good;
import com.zhjinyang.cn.domin.vo.GoodVo;
import com.zhjinyang.cn.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/15 19:20
 */
@RestController
@RequestMapping("good")
public class GoodController extends BaseController {

    @Autowired
    private GoodService goodService;

    @GetMapping
    public AxiosResult<PageResult<GoodVo>> findAll() {
        List<Good> all = goodService.findAll();
        return AxiosResult.success();
    }

    @GetMapping("{id}")
    public AxiosResult<Good> findById(@PathVariable Long id) {
        return AxiosResult.success(goodService.findById(id));
    }


    @PostMapping
    public AxiosResult<Void> add(@RequestBody Good good) {
        return toAxios(goodService.add(good));
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Good good) {
        return toAxios(goodService.update(good));
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id) {
        return toAxios(goodService.deleteById(id));
    }


}
