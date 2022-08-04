package com.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张滨
 * @time 2022/07/31 20:44
 */
public class Msg {

    private int code;
    private String msg;
    private Map<String, Object> map = new HashMap<>();

    public static Msg success() {
        Msg msg = new Msg(100, "操作成功！");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg(200, "操作失败！");
        return msg;
    }

    public Msg add(String key, Object value) {
        this.getMap().put(key,value);
        return this;
    }

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Msg() {
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

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
