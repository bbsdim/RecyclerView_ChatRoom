package com.example.vivian.voicechat;

/**
 * Created by Vivian on 2019/1/31.
 */

public class Msg {
    public static final int MSGTYPE_RECEIVED = 0;//收到的訊息
    public static final int MSGTYPE_SENT = 1;//發出的訊息
    private String msgContent;//訊息內容
    private int msgType;//訊息類別 (收到或發出)

    public String getMsgContent() {
        return msgContent;
    }

    public int getMsgType() {
        return msgType;
    }

    public Msg(String content, int type) {
        this.msgContent = content;
        this.msgType = type;
    }

}
