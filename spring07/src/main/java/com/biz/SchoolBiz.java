package com.biz;


import com.entity.School;
import sun.reflect.generics.scope.Scope;

import java.util.List;

public interface SchoolBiz {
    //查询所有
    List<School> findAll();
    //id找对象
    School fingById(Integer id);
    //保存
    void save(School school);
    //修改
    void update(School school);
    //删除
    void delete(Integer id);

}
