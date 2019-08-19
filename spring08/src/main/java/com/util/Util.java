package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@ComponentScan("com")
public class Util {

    //创建runner对象
    @Bean("queryRunner")
    @Scope("prototype")
    public static QueryRunner creatQuery(DataSource dataSource){
        return new QueryRunner(dataSource);

    }

    @Bean("dateSource")
    @Scope("prototype")
    public static DataSource creatdatesource(){
        ComboPooledDataSource ds = null;
        try{
            ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/book");
            ds.setUser("lian");
            ds.setPassword("lian");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ds;
    }

}
