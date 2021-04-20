package com.zhjinyang.cn.domin.vo;

import com.zhjinyang.cn.domin.vo.base.BaseVo;
import lombok.Data;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/18 11:31
 */
@Data
public class CategoryVo extends BaseVo {

    /**
     * 分类名称
     */
    private String catetoryName;

    /**
     * 分类父id 如果是顶级分类 父id 为0
     */
    private Long parentId;

    /**
     * 分类等级 一共三级分类 1 2 3
     */
    private Integer categoryLevel;


    private List<CategoryVo> children;


}
