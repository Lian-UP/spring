package test;

import biz.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
   /**/
    public static void main(String[] args) {
        //创建上下文对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
       // TestService service = (TestService) ac.getBean("biz");
      //  service.login();

      //  TestService service = (TestService) ac.getBean("biz2");
       // service.login();

        TestService service = (TestService) ac.getBean("biz3");
        service.login();

        ac.close();

    }

}
