package biz.impl;

import biz.TestService;

import java.util.Date;

public class TestServiceImpl2 implements TestService {

    private String name;
    private Integer age;
    private Date brithday;

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public void login() {
        System.out.println("方法被执行了");
    }
}
