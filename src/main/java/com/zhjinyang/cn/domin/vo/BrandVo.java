package com.zhjinyang.cn.domin.vo;

import com.zhjinyang.cn.domin.vo.base.BaseVo;
import lombok.Data;

/**
 * @author Zjy
 * @date 2021/4/17 9:50
 */
@Data
public class BrandVo extends BaseVo {

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
