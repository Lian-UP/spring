package com.entity;

import java.io.Serializable;

public class School implements Serializable {
    private  Integer id;
    private String username;
    private Integer pwd;

    public School() {
    }

    public School(Integer id,String username, Integer pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }
}
