package com.zhjinyang.cn.domin.criteria.base;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Zjy
 * @date 2021/4/16 22:46
 */
@Data
public class BaseQueryCriteria {

    private int currentPage=1;

    private int pageSize=5;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
