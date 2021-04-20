package com.zhjinyang.cn.controller;

import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.criteria.RoleCriteria;
import com.zhjinyang.cn.domin.entity.Role;
import com.zhjinyang.cn.domin.vo.RoleVo;
import com.zhjinyang.cn.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/20 13:35
 */
@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController extends BaseController {

    private final RoleService roleService;

    /**
     * 分页条件查询
     * @param roleCriteria
     * @return
     */
    @GetMapping
    public AxiosResult<PageResult<RoleVo>> searchPage(RoleCriteria roleCriteria) {
        PageResult<RoleVo> pageResult = roleService.searchPage(roleCriteria);
        return AxiosResult.success(pageResult);
    }

    /**
     * 根据id查询
     */
    @GetMapping("{id}")
    public AxiosResult<RoleVo> findById(@PathVariable Long id) {
        RoleVo role = roleService.findByVoId(id);
        return AxiosResult.success(role);
    }

    /**
     * 添加
     */
    @PostMapping
    public AxiosResult<Void> add(@RequestBody Role role) {
        return toAxios(roleService.add(role));
    }

    /**
     * 修改
     */
    @PutMapping
    public AxiosResult<Void> update(@RequestBody Role role) {
        return toAxios(roleService.update(role));
    }

    /**
     * 根据Id删除
     */
    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable Long id) {
        return toAxios(roleService.deleteById(id));
    }

    /**
     * 批量删除
     */
    @DeleteMapping("batch/{ids}")
    public AxiosResult<Void> batchDelete(@PathVariable List<Long> ids) {
        return toAxios(roleService.batchDeleteByIds(ids));
    }

}
