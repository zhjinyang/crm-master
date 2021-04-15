package com.zhjinyang.cn.common.http;

/**
 * @author Zjy
 * @date 2021/3/29 20:42
 */
public enum EnumStatus {
    OK(2000,"操作成功"),
    ERROR(4000,"操作失败"),
    NO_LOGIN(4001,"未登录"),
    ACCOUNT_ERROR(4002,"用户名或者邮箱不正确"),
    CODE_ERROR(4003,"验证码不正确"),
    CODE_LOSE(4004,"验证码已经失效"),
    NOT_ACTIVATED(4005,"账户未激活"),
    ;
    private int status;
    private String message;

    EnumStatus(int status, String message) {
        this.status = status;
        this.message = message;
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
}
