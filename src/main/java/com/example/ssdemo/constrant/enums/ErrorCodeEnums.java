package com.example.ssdemo.constrant.enums;


import com.example.ssdemo.constrant.ResultCode;

public enum ErrorCodeEnums {

    SYSTEM_EXCEPTION("SYSTEM_EXCEPTION", "系统异常", ResultCode.SYSTEM_ERROR),
    INTERFACE_EXCEPTION("INTERFACE_EXCEPTION", "接口异常", ResultCode.SYSTEM_ERROR),
    PARAM_VALIDATE_EXCEPTION("PARAM_VALIDATE_EXCEPTION", "参数校验异常", ResultCode.PARAM_VALIDATE_ERROR),
    USER_NOT_LOGIN_EXCEPTION("USER_NOT_LOGIN_EXCEPTION", "用户未登录", ResultCode.NOT_LOGIN_ERROR),
    USER_REPEAT_EXCEPTION("USER_REPEAT_EXCEPTION", "用户表存在重复用户信息", ResultCode.NOT_LOGIN_ERROR),
    USER_NOT_LOGINNAME_EXCEPTION("USER_NOT_LOGINNAME_EXCEPTION", "登录账号不能为空", ResultCode.NOT_LOGIN_ERROR);

    /**
     * 错误名字
     */
    private String name;

    /**
     * 错误描述
     */
    private String desc;

    /**
     * 结果编码
     */
    private int code;

    ErrorCodeEnums(String name, String desc, int code) {
        this.name = name;
        this.desc = desc;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}

