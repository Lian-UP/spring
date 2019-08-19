package com;

import com.biz.SchoolBiz;
import com.entity.School;
import com.util.SpringConfiguration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.RetentionPolicy;
import java.util.List;

/*
使用junit测试
spring整合junit
    1.导入spring-test jar包
    2.使用junit的注解把原有的main方法替换掉,替换成spring提供的 @RunWith(SpringJUnit4ClassRunner.class)
    3.告知spring的运行器,spring的IOC是基于XML还是注解,并且说明位置 @ContextConfiguration
        location:指定xml文件的位置,加上classpath关键字,表示在类路径下
        classes:指定注解类所在的位置
        导包-->替换junit集成的main方法换成spring提供的-->告知junitIOC是基于XML的还是注解的
         spring-test            @RunWith注解                       @ContextConfiguration注解
    当使用spring5版本时junit的架包必须是4.1.2以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test {

    @Autowired
    private ApplicationContext ac;
    @Autowired
    private SchoolBiz biz;
    /*
     注入失败分析
        1.应用程序的入口
            main方法
        2.junit单元测试中没有main方法也能执行
            junit集成了main方法
        3.junit不会管我们是否使用了spring
            在执行测试方法时,junit不知道我们使用的是不是spring框架
            所以也就不会读取我们的配置文件,配置类创建spring核心容器
        4.总结
            当测试方法执行时,没有IOC容器,就算写了Autowrite,也注入不了
     */
   /* @Before
    public void init(){
         ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
         biz = ac.getBean("service",SchoolBiz.class);
    }*/

    @org.junit.Test
    public void findall(){


        List<School> stus = biz.findAll();

        for(School stu:stus){
            System.out.println(stu.getUsername());

        }

    }

    @org.junit.Test
    public void findOne(){

        School stus = biz.fingById(1);

        System.out.println(stus.getUsername());
    }

    @org.junit.Test
    public void Save(){

    }

    @org.junit.Test
    public void Update(){

    }

    @org.junit.Test
    public void Delete(){

    }
}
