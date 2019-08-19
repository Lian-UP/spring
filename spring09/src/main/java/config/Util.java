package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import org.springframework.aop.IntroductionAwareMethodMatcher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/*
* 和spring连接相关的配置类
* 通过Value注解给参数赋值
* 引入
* */
//@Configuration
public class Util {

    @Value("${jdbc.driver}")
    private  String driver;
    @Value("${jdbc.url}")
    private  String url;
    @Value("${jdbc.user}")
    private  String user;
    @Value("${jdbc.password}")
    private  String password;

    //创建runner对象
    @Bean("queryRunner")
    public  QueryRunner creatQuery(@Qualifier("ds2") DataSource dataSource){
        return new QueryRunner(dataSource);

    }

    @Bean(name = "ds1")
    public  DataSource creatdatesource(){
        ComboPooledDataSource ds = null;
        try{
            ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            //上面写死了
        }catch (Exception e){
            e.printStackTrace();
        }
        return ds;
    }

    @Bean(name = "ds2")
    public  DataSource creatdatesource1(){
        ComboPooledDataSource ds = null;
        try{
            ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/book2?serverTimezone=UTC");
            ds.setUser(user);
            ds.setPassword(password);
            //上面写死了
        }catch (Exception e){
            e.printStackTrace();
        }
        return ds;
    }
}
