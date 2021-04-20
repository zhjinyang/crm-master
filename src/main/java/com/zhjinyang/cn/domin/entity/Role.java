package com.zhjinyang.cn.domin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhjinyang.cn.domin.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zjy
 * @date 2021/4/20 13:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class Role extends BaseEntity {


    private String roleName;

    private String roleDesc;

}
