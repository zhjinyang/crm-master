package com.zhjinyang.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.domin.criteria.DeptCriteria;
import com.zhjinyang.cn.domin.entity.Dept;
import com.zhjinyang.cn.domin.vo.DeptVo;
import com.zhjinyang.cn.mapper.DeptMapper;
import com.zhjinyang.cn.service.DeptService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import com.zhjinyang.cn.transfer.DeptTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/14 23:16
 */
@Service
@Transactional
@RequiredArgsConstructor
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    private final DeptMapper deptMapper;
    private final DeptTransfer deptTransfer;


    @Override
    public PageResult<DeptVo> searchPage(DeptCriteria deptCriteria) {
        PageHelper.startPage(deptCriteria.getCurrentPage(), deptCriteria.getPageSize());
        LambdaQueryWrapper<Dept> lambda = new QueryWrapper<Dept>().lambda();
        if (deptCriteria.isQuery()) {
            //        如果是查询 查询的不一定是第一级数据 所以不能拼接一级的条件
            if (!StringUtils.isEmpty(deptCriteria.getDeptName())) {
                lambda.like(Dept::getDeptName, deptCriteria.getDeptName());
            }
            if (!StringUtils.isEmpty(deptCriteria.getStartTime()) && !StringUtils.isEmpty(deptCriteria.getEndTime())) {
                lambda.between(Dept::getCreateTime, deptCriteria.getStartTime(), deptCriteria.getEndTime());
            }
        } else {
            //如果不是条件查询 则查询的是第一级
            lambda.eq(Dept::getParentId, 0).orderByAsc(Dept::getDeptSort);
        }
        List<Dept> depts = deptMapper.selectList(lambda);
        PageInfo<Dept> pageInfo = new PageInfo<>(depts);
        return new PageResult<DeptVo>(pageInfo.getTotal(), deptTransfer.toVO(depts));
    }

    @Override
    public List<DeptVo> getSuperByParent(Long parentId, ArrayList<DeptVo> list) {
        //如果查询的父id是0就是一级，直接返回一级
        if (parentId.longValue() == 0) {
            list.addAll(this.getChildrenById(0L));
            return list;
        } else {
            list.addAll(this.getChildrenById(parentId));
            return getSuperByParent(findById(parentId).getParentId(), list);
        }
    }

    /**
     * 级联递归删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteSelfAndChildren(Long id) {
        ArrayList<Long> deleteIds = new ArrayList<>();
        deleteIds.add(id);
        setChildrenId(deleteIds, id);
        return batchDeleteByIds(deleteIds);
    }

    //封装要递归删除的孩子
    private void setChildrenId(List<Long> ids, Long id) {
        List<DeptVo> children = getChildrenById(id);
        children.forEach(item -> {
            ids.add(item.getId());
            setChildrenId(ids, item.getId());
        });
    }


    //通过部门id找孩子
    @Override
    public List<DeptVo> getChildrenById(Long id) {
        LambdaQueryWrapper<Dept> queryWrapper = new QueryWrapper<Dept>().lambda().eq(Dept::getParentId, id).orderByAsc(Dept::getDeptSort);
        List<Dept> depts = deptMapper.selectList(queryWrapper);
        return deptTransfer.toVO(depts);
    }
}
