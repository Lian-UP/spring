package com.dao.impl;

import com.dao.SchoolDao;
import com.entity.School;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class SchoolDaoImpl implements SchoolDao {

    private QueryRunner queryRunner;

    public List<School> findAll() {
        try {
            return queryRunner.query("select * from school",new BeanListHandler<School>(School.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public School fingById(Integer id) {
        try {
            return queryRunner.query("select * from school where id=?",new BeanHandler<School>(School.class),id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void save(School school) {
        try {
             queryRunner.update("INSERT INTO school VALUES(?,?,0)",new BeanHandler<School>(School.class),school.getUsername(),school.getPwd());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void update(School school) {
        try {
            queryRunner.update("update  school set username=?,pwd=? where id=?",new BeanHandler<School>(School.class),school.getUsername(),school.getPwd(),school.getId());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void delete(Integer id) {
        try {
            queryRunner.update("delete school where id=?",id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }
}
