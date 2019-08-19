package test;

import com.biz.TestService;
import com.dao.impl.TestDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
   /**/
    public static void main(String[] args) {
        //创建上下文对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        TestService service = (TestService) ac.getBean("service");
       // TestDaoImpl dao = (TestDaoImpl) ac.getBean("testDaoImpl");
        TestService service2 = (TestService) ac.getBean("service");
       System.out.println(service==service2);
      // System.out.println(dao);

       service.login();

        ac.close();

    }

}
