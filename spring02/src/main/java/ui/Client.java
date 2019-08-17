package ui;

import com.hfxt.service.TestService;
import factory.BeanFactory;

/*
* 模拟表现出调用业务层
* */
public class Client {
    public static void main(String[] args){
        //创建对象
       // TestService service = new TestServiceImpl();
        //通过Bean Factory获取配置文件中的对象全限定类名
                for (int i=0;i<5;i++){
                    //每次创建的对象都是同一个,操作的数据也是同一个所有会增加
                    //每次调用都是容器里保存的对象,就是单例模式了
                    TestService service = (TestService) BeanFactory.getBean("accontService");
                    System.out.println(service);
                    service.saveAccount();
                }
    }
}
