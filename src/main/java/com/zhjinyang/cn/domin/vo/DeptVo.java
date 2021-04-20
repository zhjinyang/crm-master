package com.zhjinyang.cn.domin.vo;

import com.zhjinyang.cn.domin.vo.base.BaseVo;
import lombok.Data;

import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/19 21:16
 */
@Data
public class DeptVo extends BaseVo {


    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门的上级部门id 如果是一级部门 则父id为0
     */
    private Long parentId;

    /**
     * 部门排序
     */
    private Integer deptSort;

    /**
     * 部门描述
     */
    private String deptDesc;

    //是否有孩子
    Boolean hasChildren;

    //孩子
    List<DeptVo> children;

    /**
     * 是否是叶子节点  结果和hasChildren相反的值.没有孩子的节点就是叶子节点
     */
    Boolean isLeaf;


}
