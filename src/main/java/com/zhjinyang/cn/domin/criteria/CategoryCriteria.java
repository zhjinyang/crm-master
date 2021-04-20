package com.zhjinyang.cn.domin.criteria;

import com.zhjinyang.cn.domin.criteria.base.BaseQueryCriteria;
import lombok.Data;

/**
 * @author Zjy
 * @date 2021/4/16 22:49
 */
@Data
public class CategoryCriteria extends BaseQueryCriteria {

    /**
     * 分类名称
     */
    private String catetoryName;

}
