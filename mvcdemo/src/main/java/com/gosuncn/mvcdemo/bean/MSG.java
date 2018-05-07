package com.gosuncn.mvcdemo.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weiye on 2018/5/5 0005.
 * 服务器返回数据格式
 */

public class MSG<T> {
    //100表示成功 200表示失败
    private int statusCode;
    //自定义返回信息
    private String message;
    //用来放对象
    private Map<String,T> extend=new HashMap<String,T>();

    //响应码为100时返回成功信息
    public static MSG success(){
        MSG result=new MSG();
        result.setStatusCode(100);
        result.setMessage("处理成功了");
        return result;
    }
    //响应码为200时返回失败信息
    public static MSG fail(){
        MSG result=new MSG();
        result.setStatusCode(200);
        result.setMessage("处理失败了");
        return result;
    }

    //定义添加对象的方法
    public MSG add(String key,T value){
        this.extend.put(key, value);
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Map<String, T> getExtend() {
        return extend;
    }
    public void setExtend(Map<String, T> extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "MSG{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", extend=" + extend +
                '}';
    }
}
