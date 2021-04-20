package com.zhjinyang.cn.service;

import com.zhjinyang.cn.common.page.PageResult;
import com.zhjinyang.cn.domin.criteria.RoleCriteria;
import com.zhjinyang.cn.domin.entity.Role;
import com.zhjinyang.cn.domin.vo.RoleVo;
import com.zhjinyang.cn.service.base.BaseService;

/**
 * @author Zjy
 * @date 2021/4/20 13:33
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 分页条件查询
     * @param roleCriteria
     * @return
     */
    PageResult<RoleVo> searchPage(RoleCriteria roleCriteria);

    RoleVo findByVoId(Long id);
}
