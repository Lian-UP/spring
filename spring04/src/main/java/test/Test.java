package test;

import biz.TestService;
import dao.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
   /**/
    public static void main(String[] args) {
        //创建上下文对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        TestService service = (TestService) ac.getBean("biz");
        service.login();
    }

}
