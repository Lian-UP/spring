package com;

import com.biz.SchoolBiz;
import com.entity.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/*
使用junit测试
 */
public class Test {

    @org.junit.Test
    public void findall(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        SchoolBiz biz = ac.getBean("service",SchoolBiz.class);

        List<School> stus = biz.findAll();

        for(School stu:stus){
            System.out.println(stu.getUsername());

        }

    }

    @org.junit.Test
    public void findOne(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        SchoolBiz biz = ac.getBean("service",SchoolBiz.class);

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
