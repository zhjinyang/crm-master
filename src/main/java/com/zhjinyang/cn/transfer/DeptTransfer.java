package com.zhjinyang.cn.transfer;

import com.zhjinyang.cn.domin.entity.Dept;
import com.zhjinyang.cn.domin.vo.DeptVo;
import com.zhjinyang.cn.mapper.DeptMapper;
import com.zhjinyang.cn.transfer.base.BaseTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/19 21:22
 */
@Component
@RequiredArgsConstructor
public class DeptTransfer extends BaseTransfer<Dept, DeptVo> {

    private final DeptMapper deptMapper;

    @Override
    public List<DeptVo> toVO(List<Dept> list) {
        List<DeptVo> deptVos = super.toVO(list);
        deptVos.forEach(deptVo -> {
            int childrenCount = deptMapper.getChildrenCount(deptVo.getId());
            deptVo.setHasChildren(childrenCount > 0);
            deptVo.setIsLeaf(childrenCount <= 0);
        });
        return deptVos;
    }


}
