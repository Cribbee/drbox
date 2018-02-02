package com.lxy11.drbox.utils;

public class ResultMsg {
    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int Code, String Msg, Object Data)
    {
        this.code = Code;
        this.msg = Msg;
        this.data = Data;
    }
    public int getErrcode() {
        return code;
    }
    public void setErrcode(int code) {
        this.code = code;
    }
    public String getErrmsg() {
        return msg;
    }
    public void setErrmsg(String msg) {
        this.msg = msg;
    }
    public Object getP2pdata() {
        return data;
    }
    public void setP2pdata(Object data) {
        this.data = data;
    }
}