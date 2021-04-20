package com.zhjinyang.cn.domin.vo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Zjy
 * @date 2021/4/17 9:47
 * 返回给前端的基类
 */
@Data
public class BaseVo implements Serializable {


    private Long id;

    /**
     * 创建者
     */
    @JsonIgnore
    private Long createBy;

    /**
     * 创建时间
     */
    @JsonIgnore
    private LocalDateTime createTime;

    /**
     * 修改者
     */
    @JsonIgnore
    private Long updateBy;

    /**
     * 修改时间
     */
    @JsonIgnore
    private LocalDateTime updateTime;


}
