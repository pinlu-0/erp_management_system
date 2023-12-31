package com.aaa.until;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    //状态码  100-失败   200-成功
    private int code;
    //提示信息
    private String msg;
    //用户要返回给浏览器的数据
    private Map<String,Object> extend = new HashMap<String, Object>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(1);
        result.setMsg("处理成功!");
        return result ;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(-1);
        result.setMsg("处理失败!");
        return result ;
    }

    public Msg add(String string, Object object) {
        this.getExtend().put(string, object);
        return this;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Map<String, Object> getExtend() {
        return extend;
    }
    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

}

