package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
* 创建Bean对象的工厂
* Bean:可重用的组件
* javaBean:java编写的可重用的组件
* 创建service和dao对象的
* 1.需要一个配置文件来配置service和dao
*   配置的内容:唯一标识=全限定类名(key-value)
* 2.通过反射读取配置文件的内容,反射创建对象
*
* 配置文件可以是xml也可以是properties
* */
public class BeanFactory {
    //定义一个properties对象
    private static Properties pros;
    //定义一个map用于存放要创建的对象
    private static Map<String,Object> beans;
    //使用静态代码块为Properties赋值
    static {
        try {
            //实例化
            pros = new Properties();
            //获取流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pros.load(in);
            //多例
            //---------------------------------------------------------------
            //单例
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出所有的key  枚举类型
            Enumeration keys = pros.keys();
            //遍历枚举
            while(keys.hasMoreElements()) {
                //取出key
                String key = keys.nextElement().toString();
                //根据key取出value
                String beanpath = pros.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanpath).newInstance();
                //把反射的对象放进容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    //根据名称获取对象--单例
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
    /*
    * 根据bean名称获取对象
    * 多例
    * */
    /*public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = pros.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
