package com.zc.myboot.base;

import java.io.Serializable;

/**
 * @author: zc
 * @date: 2017/11/27
 */
public class BaseEntity implements Serializable{

    protected int page = 1;
    protected int size = 20;
    protected String sidx = "id";
    protected String sord = "asc";

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
}
