package com.haod.www.chatroot.base;

public class TalkBean {

    public String talk_content;

    public boolean isAsk;

    public int imageId;

    public TalkBean(String talk_content, boolean isAsk, int imageId) {
        this.talk_content = talk_content;
        this.isAsk = isAsk;
        this.imageId = imageId;
    }

}
