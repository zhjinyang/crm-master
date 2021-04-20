package com.zhjinyang.cn.domin.vo;

import com.zhjinyang.cn.domin.vo.base.BaseVo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Zjy
 * @date 2021/4/17 20:37
 */
@Data
public class GoodVo extends BaseVo {

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品价格
     */
    private BigDecimal goodPrice;

    /**
     * 商品描述
     */
    private String goodDesc;

    /**
     * 商品页面静态化使用的
     */
    private String goodContent;

    /**
     * 商品图片
     */
    private String goodImg;

    /**
     * 品牌名称
     */
    private Long brandName;

}
