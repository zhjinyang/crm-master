package com.zhjinyang.cn.service;

import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.domin.criteria.DeptCriteria;
import com.zhjinyang.cn.domin.entity.Dept;
import com.zhjinyang.cn.domin.vo.DeptVo;
import com.zhjinyang.cn.service.base.BaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/14 23:15
 */
public interface DeptService extends BaseService<Dept> {

    /**
     * 分页条件查询
     * @param deptCriteria
     * @return
     */
    PageResult<DeptVo> searchPage(DeptCriteria deptCriteria);

    /**
     * 通过一个部门父id 找到同级以及上一级 上上一级...
     * @param parentId
     * @return
     */
    List<DeptVo> getSuperByParent(Long parentId, ArrayList<DeptVo> list);

    /**
     * 级联递归删除,删除自己和孩子
     * @param id
     * @return
     */
    int deleteSelfAndChildren(Long id);

    /**
     * 根据id找孩子
     * @param id
     * @return
     */
    List<DeptVo> getChildrenById(Long id);

}
