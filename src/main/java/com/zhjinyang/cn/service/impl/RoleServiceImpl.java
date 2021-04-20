package com.zhjinyang.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.domin.criteria.RoleCriteria;
import com.zhjinyang.cn.domin.entity.Role;
import com.zhjinyang.cn.domin.vo.RoleVo;
import com.zhjinyang.cn.mapper.RoleMapper;
import com.zhjinyang.cn.service.RoleService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import com.zhjinyang.cn.transfer.RoleTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/20 13:33
 */
@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    private final RoleMapper roleMapper;

    private final RoleTransfer roleTransfer;


    /**
     * 分页条件查询
     *
     * @param roleCriteria
     * @return
     */
    @Override
    public PageResult<RoleVo> searchPage(RoleCriteria roleCriteria) {
        PageHelper.startPage(roleCriteria.getCurrentPage(), roleCriteria.getPageSize());
        LambdaQueryWrapper<Role> lambda = new QueryWrapper<Role>().lambda();

        if (!StringUtils.isEmpty(roleCriteria.getRoleName())) {
            lambda.like(Role::getRoleName, roleCriteria.getRoleName());
        }
        LocalDateTime startTime = roleCriteria.getStartTime();
        LocalDateTime endTime = roleCriteria.getEndTime();

        if (startTime != null && endTime != null) {
            lambda.between(Role::getCreateTime, startTime, endTime);
        }
        List<Role> roles = roleMapper.selectList(lambda);

        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        long total = pageInfo.getTotal();

        List<RoleVo> roleVos = roleTransfer.toVO(roles);
        PageResult<RoleVo> pageResult = new PageResult<>(total, roleVos);

        return pageResult;
    }

    /**
     * 通过id查询后转换为vo
     *
     * @param id
     * @return
     */
    @Override
    public RoleVo findByVoId(Long id) {
        Role byId = findById(id);
        RoleVo roleVo = roleTransfer.toVO(byId);
        return roleVo;
    }
}
