package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
    private static DataSource ds = new ComboPooledDataSource();

    // 获取连接池
    public static DataSource getDataSource() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ds = ac.getBean("dateSource",DataSource.class);
        return ds;
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭连接
     * @param resultSet
     * @param pst
     * @param connection
     */
    public static void close(ResultSet resultSet, PreparedStatement pst, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
