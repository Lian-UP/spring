package factory;

import biz.TestService;
import biz.impl.TestServiceImpl;

/*
* 模拟一个工厂类(该类可能存在于jar包中,我们无法修改源码来提供默认构造函数)
* */
public class StaticFactory {

    public static TestService getService(){
        return new TestServiceImpl();
    }
}
