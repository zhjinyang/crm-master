package com.zhjinyang.cn.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Zjy
 * @date 2021/3/29 20:31
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
//这个注解表示转json字符串时候，如果属性为空，json字符串中不会有这个属性
public class AxiosResult<T> {
    private int status;
    private String message;
    private T data;

    /**
     * 返回成功
     * @return
     */
    public static <T> AxiosResult<T> success(){
        return getAxiosResult(EnumStatus.OK,null);
    }

    /**
     * 返回成功携带数据
     */
    public static <T> AxiosResult<T> success(T data){
        return getAxiosResult(EnumStatus.OK,data);
    }

    /**
     * 返回失败
     */
    public static <T> AxiosResult<T> error(){
        return getAxiosResult(EnumStatus.ERROR,null);
    }

    /**
     * 返回失败携带错误信息
     */
    public static <T> AxiosResult<T> error(T data){
        return getAxiosResult(EnumStatus.ERROR,data);
    }

    public static <T> AxiosResult<T> error(EnumStatus enumStatus){
        return getAxiosResult(enumStatus,null);
    }


    private static <T> AxiosResult<T> getAxiosResult(EnumStatus enumStatus, T data) {
        return new AxiosResult<T>(enumStatus, data);
    }

    private AxiosResult(EnumStatus enumStatus, T data) {
        this.status = enumStatus.getStatus();
        this.message = enumStatus.getMessage();
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
