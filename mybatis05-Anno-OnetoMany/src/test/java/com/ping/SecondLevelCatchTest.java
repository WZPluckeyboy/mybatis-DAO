package com.ping;

import com.ping.Dao.IUserDao;
import com.ping.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class SecondLevelCatchTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao iUserDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }
    @After
    public void destory() throws  Exception{
        in.close();
    }
    @Test
    public void findONeTest(){
        session = factory.openSession();
        iUserDao= session.getMapper(IUserDao.class);
        User user=  iUserDao.findById(48);
        System.out.println(user);
        session.close();
      SqlSession session1=factory.openSession();
      IUserDao iUserDao1=session1.getMapper(IUserDao.class);
        User user1=  iUserDao1.findById(48);
        System.out.println(user1);
        session.close();
    }
}
