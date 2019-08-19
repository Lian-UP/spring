package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import config.Util;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/*
* 配置类,和bean.xml相同
* spring中的新注解
*   Configuration:指定当前类是一个配置类
*   ComponentScan:用于通过注解指定spring在创建时要扫描的包
*       属性:value 和basePackages作用一样,都是用于指定容器时要扫描的包
*       使用此注解等同于在xml中配置了  <context:component-scan base-package="com"></context:component-scan>
*   Bean:用于把当前方法的返回值当作bean对象存入springIOC容器中
*       属性:name用于指定bean的id,默认值是当前方法的名称
*       细节:如果方法有参数时,spring容器回去查找有没有可用的bean对象,
*           查找的方式和Autowrite一样
*       细节:当配置类作为AnnotationConfigApplicationContext对象创建的参数shi,可以不写
*           Util类要加入扫描两种方式:
*                       1.加上注解@Configuration,并加入扫描
*                       2.在创建AnnotationConfigApplicationContext时把Util.class加在后面
*   Import注解:引入其他配置类,把其他配置类加到主配置类中,只要加载主配置类就能实现注入
*       属性:value 引入其他配置类
*                  有Import注解的是父配置类,引入的都是子配置类
*   PropertySource:用于指定properties文件的位置
*       属性:value:指定文件名称和路径
*               关键字:classpath表示是类路径
*
* */
//@Configuration
@ComponentScan("com")// <context:component-scan base-package="com"></context:component-scan>
@Import(Util.class)
@PropertySource("classpath:jdbcconfig.properties")
public class SpringConfiguration {

  /*  //创建Query Runner并把返回值存入spring容器
    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner creatRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    //创建DateSource并把返回值存入spring容器
    @Bean(name = "dateSource")
    public static DataSource creatdatesource(){
        ComboPooledDataSource ds = null;
        try{
            ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            //不加?serverTimezone=UTC 会报错
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/book?serverTimezone=UTC");
            ds.setUser("lian");
            ds.setPassword("lian");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ds;
    }*/
}
