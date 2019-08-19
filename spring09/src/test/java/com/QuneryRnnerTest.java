package com;

import com.util.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QuneryRnnerTest {

    @Test
    public void testQuery(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner = ac.getBean("queryRunner",QueryRunner.class);
        QueryRunner queryRunner2 = ac.getBean("queryRunner",QueryRunner.class);
        //加上Scop注解
        System.out.println(queryRunner==queryRunner2);
    }
}
