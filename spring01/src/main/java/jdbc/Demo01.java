package jdbc;

import java.sql.*;

/*
* 程序的耦合
* 耦合:程序间的依赖关系
*   包括:类之间的依赖
*       方法之间的依赖
*       独立性差
* 解耦:降低程序间的依赖关系
*       在编译器不依赖,运行时才依赖
* 思路:
*   1.使用反射来创建对象,而并非使用new关键字
*   2.通过读取配置文件来获取要创建的对象全限定名
* */
public class Demo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动
       // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        /*
          上面依赖一个驱动类
          下面的问题是,字符串被写死了,不便于后期维护代码
          编译期没有错误,在运行时才可能出错

         */
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","lian","lian");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from school");
        //4.执sql,得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("username"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }



}
