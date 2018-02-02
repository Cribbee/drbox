package com.lxy11.drbox.utils;

public enum ResultStatusCode {
    OK(0, "OJBK"),
    SYSTEM_ERR(30001, "有错误，找网管");

    private int code;
    private String msg;
    public int getErrcode() {
        return code;
    }

    public void setErrcode(int ecode) {
        this.code = code;
    }

    public String getErrmsg() {
        return msg;
    }

    public void setErrmsg(String msg) {
        this.msg = msg;
    }
    private ResultStatusCode(int Code, String Msg)
    {
        this.code = Code;
        this.msg = Msg;
    }
}
