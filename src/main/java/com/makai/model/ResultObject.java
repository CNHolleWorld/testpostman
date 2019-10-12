package com.makai.model;

/* * *
 *  @Name: ResultObject
 *  @User: 马凯
 *  @Date: 2019/10/9
 *  @Remark: 返回的对象信息
 *  code: 返回响应的状态码
 *
 * * */
public class ResultObject {

    private  int code;
    private  String msg;
    private  Object date;

    public ResultObject() {
    }

    public ResultObject(int code, String msg, Object date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
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

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
