package biz.impl;

import biz.TestService;
import dao.TestDao;
import dao.impl.TestDaoImpl;

public class TestServiceImpl implements TestService {

    private TestDao testDao = new TestDaoImpl();

    public void login() {

        testDao.login();


    }
}
