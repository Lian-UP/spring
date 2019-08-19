package com.biz.impl;

import com.biz.SchoolBiz;
import com.dao.SchoolDao;
import com.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolBizImp implements SchoolBiz {

    private SchoolDao schoolDao;

    public void setSchoolDao(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    public List<School> findAll() {
        return schoolDao.findAll();
    }

    public School fingById(Integer id) {
        return schoolDao.fingById(id);
    }

    public void save(School school) {
        schoolDao.save(school);
    }

    public void update(School school) {
        schoolDao.update(school);
    }

    public void delete(Integer id) {
        schoolDao.delete(id);
    }
}
