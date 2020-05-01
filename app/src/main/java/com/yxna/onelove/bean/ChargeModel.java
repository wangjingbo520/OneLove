package com.yxna.onelove.bean;

/**
 * @author wjb（H）
 * @date describe
 */
public class ChargeModel {
    private String momey;
    private boolean isCheck;
    private String content;

    public ChargeModel(String content, String momey) {
        this.momey = momey;
        this.content = content;
    }

    public String getMomey() {
        return momey;
    }

    public void setMomey(String momey) {
        this.momey = momey;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
