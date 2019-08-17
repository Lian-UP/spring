package biz.impl;

import biz.TestService;

import java.util.Date;

public class TestServiceImpl implements TestService {

    private String name;
    private Integer age;
    private Date brithday;

    public  TestServiceImpl(String name,Integer age,Date brithday){
        this.age = age;
        this.name = name;
        this.brithday = brithday;
        System.out.println(name+"\t"+age+"\t"+brithday);
    }

    public void login() {
        System.out.println("方法被执行了");
    }
}
