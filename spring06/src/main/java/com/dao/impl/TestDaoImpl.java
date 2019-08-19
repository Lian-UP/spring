package com.dao.impl;

import com.dao.TestDao;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {
    public void login() {
        System.out.println("模拟登录111111");
    }
}
