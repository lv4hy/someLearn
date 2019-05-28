package com.szx.netty.LRU;

public class DLinkNode {

    private String key;
    private int value;
    private DLinkNode pre;
    private DLinkNode post;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DLinkNode getPre() {
        return pre;
    }

    public void setPre(DLinkNode pre) {
        this.pre = pre;
    }

    public DLinkNode getPost() {
        return post;
    }

    public void setPost(DLinkNode post) {
        this.post = post;
    }
}
