package com.zhjinyang.cn.domin.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Zjy
 * @date 2021/4/14 22:52
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改者
     */
    private Long updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public void setData() {
        if (id == null) {
            //添加
            this.createBy = 1L;
            this.createTime = LocalDateTime.now();
        } else {
            //修改
            this.updateBy = 2L;
            this.updateTime = LocalDateTime.now();
        }
    }

}
