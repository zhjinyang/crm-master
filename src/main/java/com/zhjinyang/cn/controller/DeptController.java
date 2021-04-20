package com.zhjinyang.cn.controller;

import com.zhjinyang.cn.common.http.AxiosResult;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.common.utils.TreeUtils;
import com.zhjinyang.cn.controller.base.BaseController;
import com.zhjinyang.cn.domin.criteria.DeptCriteria;
import com.zhjinyang.cn.domin.entity.Dept;
import com.zhjinyang.cn.domin.vo.DeptVo;
import com.zhjinyang.cn.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zjy
 * @date 2021/4/15 19:20
 */
@RestController
@RequestMapping("dept")
@RequiredArgsConstructor
public class DeptController extends BaseController {

    private final DeptService deptService;


    //条件分页查询
    @GetMapping
    public AxiosResult<PageResult<DeptVo>> findAll(DeptCriteria deptCriteria) {
        PageResult<DeptVo> all = deptService.searchPage(deptCriteria);
        return AxiosResult.success(all);
    }

    @GetMapping("{id}")
    public AxiosResult<Map<String, Object>> findById(@PathVariable Long id) {
        Dept dept = deptService.findById(id);
        List<DeptVo> parents = deptService.getSuperByParent(dept.getParentId(), new ArrayList<>());

        //构建tree
        List<DeptVo> deptVos = TreeUtils.buildTree(parents);
        Map<String,Object> map = new HashMap<>();
        map.put("info",dept);
        map.put("elements",deptVos);
        return AxiosResult.success(map);
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
        return toAxios(deptService.deleteSelfAndChildren(id));
    }

    @GetMapping("{id}/children")
    public AxiosResult<List<DeptVo>> getChildrenById(@PathVariable Long id){
        return AxiosResult.success(deptService.getChildrenById(id));
    }


}
