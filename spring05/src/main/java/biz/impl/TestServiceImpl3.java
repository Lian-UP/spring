package biz.impl;

import biz.TestService;

import java.util.*;

public class TestServiceImpl3 implements TestService {

    private String [] strs;
    private List<String> list;
    private Set<String> set;
    private Map<String,Object> maps;
    private Properties properties;

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void login() {
        System.out.println(Arrays.toString(strs));
        System.out.println(list);
        System.out.println(set);
        System.out.println(maps);
        System.out.println(properties);
    }
}
