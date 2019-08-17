package com.hfxt.service;

import com.hfxt.dao.AccontDao;
import com.hfxt.dao.AccontDaoImpl;
import factory.BeanFactory;

/*
* 业务实现层
* */
public class TestServiceImpl implements TestService{

    //private AccontDao accontDao = new AccontDaoImpl();
    private AccontDao accontDao = (AccontDao) BeanFactory.getBean("accontDao");

    public void saveAccount() {
        int i = 1;
        accontDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
