package com.ping.test;
import com.ping.Dao.IUsersDao;
import com.ping.domain.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    public static void main(String[] args) throws Exception {
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工程
        SqlSessionFactoryBuilder build=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=build.build(in);
        //3.创建SqlSession对象
        SqlSession session=factory.openSession();
        //4.使用SqlSession对象创建Dao的代理的对象
        IUsersDao usersDao=session.getMapper(IUsersDao.class);
        //5.使用代理对象执行方法
        List<Users> users=usersDao.findAll();
        for(Users user:users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
