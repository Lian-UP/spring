package biz.impl;

import biz.TestService;
import dao.TestDao;
import dao.impl.TestDaoImpl;

public class TestServiceImpl implements TestService {

    public TestServiceImpl(){
        System.out.println("对象被创建了");
    }
    public void login() {
        System.out.println("方法被执行了");
    }
}
