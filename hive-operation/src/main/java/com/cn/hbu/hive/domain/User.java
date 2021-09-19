package com.cn.hbu.hive.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String usercode;
    private String username;
    private Integer orgtype;
    private String regdate;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(Integer orgtype) {
        this.orgtype = orgtype;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", orgtype=" + orgtype +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
