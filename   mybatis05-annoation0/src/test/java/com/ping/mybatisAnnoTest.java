package com.ping;

import com.ping.Dao.IUserDao;
import com.ping.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisAnnoTest {
    public static void main(String[] args) throws IOException {
        InputStream in;
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        List<User> users = iUserDao.findAll();
        for (User user: users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
