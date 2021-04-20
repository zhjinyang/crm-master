package com.zhjinyang.cn.domin.criteria;

import com.zhjinyang.cn.domin.criteria.base.BaseQueryCriteria;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author Zjy
 * @date 2021/4/19 21:14
 */
@Data
public class DeptCriteria extends BaseQueryCriteria {

    private String deptName;


    /**
     * 判断是否是查询
     *
     * @return
     */
    public boolean isQuery() {
        return !StringUtils.isEmpty(this.deptName) || (!StringUtils.isEmpty(this.getStartTime()) && !StringUtils.isEmpty(this.getEndTime()));
    }


}
