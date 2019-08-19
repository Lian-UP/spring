package com.biz.impl;

import com.biz.TestService;
import com.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*
* 曾经bean注入  <bean id="biz" class="biz.impl.TestServiceImpl"
*     scope="" init-method="" destory-method="" >
*   <property name="" value="" ref=""> </property>
*   </bean>
*  用于创建对象的注解
*       和xml文件中编写一个备案标签实现的功能一样
*       @Component:把当前对象存入spring容器中
*                 属性:value--用于指定bean中的ID.当不写时它默认值是当前类名首字母小写
*       @Controller--一般用于表现层
*       @Service--一般用于业务层
*       @Repository--一般用于持久层
*       作用和Component作用一样,他们是spring为我们提供明确三层使用的注解,让我们的三层对象更加清晰
* 用于注入数据的
*       和xml中的bean中的property标签一样
*       Autowired:自动按照类型注入,只要容器中有唯一的一个bean对象类型和要注入的遍历类型匹配,就可以注入成功
*           出现位置:变量上,方法上
*           细节:使用注解注入时,set方法就不是必须的.
*           注入时:把spring容器看出一个key=value的形式,Autowired是根据和value比对来创建对象
*                 有多个匹配时先根据类型查找到value,再根据名称查找key(bean中的id)匹配的值,两个都不一样就会报错
*       Qualifier:按照类型注入的基础上,再按照名称注入.再给类成员注入时不能单独使用.但是给方法参数注入时可以
*              属性:value,指定注入bean的id
*              作为类成员变量的注解时需要和Autowrite同时使用
*       Resource:直接根据bean的id注入
*               属性:name,用于指定bean的id
* 只能用于注入其他bean类型的数据,其他基本类型String无法使用以上注解实现,集合类型的注入只能通过XML来实现
*       @Value:用于注入基本类型和String类型
*               属性:value--用于指定数据的值,它可以使用spring中的SpEL(el表达式)
*               SpEL的写法${表达式}
* 用于改变作用范围的
*       和xml文件中bean标签中使用scope标签一样
*       Scope:用于指定bean的作用范围
*           属性:value:指定范围的取值;常用取值:singleton单例(默认) 和 prototype
* 和生命周期相关的
*       和xml中bean标签中init-method, destory-method作用一样
*       PreDestroy:指定销毁方法
*       PostConstruct:指定初始化方法
* */
@Component("service")
//@Scope(value = "prototype")
public class TestServiceImpl implements TestService {

   /* @Autowired
    @Qualifier("testDaoImpl2")*/
   @Resource(name = "testDaoImpl2")
    private TestDao testDao;

   //初始化
   @PostConstruct
   public void init(){
       System.out.println("初始化方法执行了");
   }
    //销毁
   @PreDestroy
   public void destroy(){
       System.out.println("销毁方法执行了");
   }

    public void login() {
        testDao.login();
    }
}
