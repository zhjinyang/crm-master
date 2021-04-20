package com.zhjinyang.cn.domin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhjinyang.cn.domin.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author codeyancy
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("base_brand")
public class Brand extends BaseEntity {





    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌描述
     */
    private String brandDesc;

    /**
     * 品牌LOGO
     */
    private String brandLogo;

    /**
     * 品牌官网
     */
    private String brandSite;



}
