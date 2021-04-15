package com.zhjinyang.cn.controller.base;

import com.zhjinyang.cn.common.http.AxiosResult;

/**
 * @author Zjy
 * @date 2021/4/14 22:42
 */
public class BaseController {

    protected AxiosResult<Void> toAxios(int row) {
        return row > 0 ? AxiosResult.success() : AxiosResult.error();
    }
}
