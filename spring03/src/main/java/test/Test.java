package test;

import biz.TestService;
import biz.impl.TestServiceImpl;
import dao.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    /*
    * 获取springIOC核心容器根据id获取class中的全限定类名
    * ApplicationContext的三个常用实现类:
    *       ClassPathXmlApplicationContext(配置文件名)
    *       FileSystemXmlApplicationContext(全路径)
    *       AnnotationConfigApplicationContext()  注解
    * 核心容器的两个接口的问题
    *     ApplicationContext:  单例对象适用  开发中更多使用Applicationcontext
    *           他在构建核心容器时,创建对象采用的是立即加载的方式,也就是说只要读取完配置文件立即创建对象
    *     BeanFactory:          多例对象适用
    *           他在核心容器时,采用延迟加载的方式,也就是说什么时候根据获取对象了,什么时候才真正创建对象
    * */
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据ID获取bean对象
        //获取一个Object类型的对象需要强转
        TestService service = (TestService) ac.getBean("biz");
        //通过字节码强转获取对象
        TestDao dao = ac.getBean("dao",TestDao.class);
        System.out.println(service);
        System.out.println(dao);
    }

}
