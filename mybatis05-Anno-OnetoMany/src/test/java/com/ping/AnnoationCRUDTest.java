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
import java.util.Date;
import java.util.List;

public class AnnoationCRUDTest {
    private   InputStream in;
    private   SqlSessionFactory factory;
    private   SqlSession session;
    private   IUserDao iUserDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        iUserDao= session.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws  Exception{
        session.close();
        in.close();
    }
    //查询全部
    @Test
    public void findAllTest(){
        List<User> users = iUserDao.findAll();
        for (User user: users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    //保存数据
    //查询一个
    @Test
    public void findONeTest(){
      User user=  iUserDao.findById(48);
        System.out.println(user);
    }
    @Test
    public void findByNameTest(){
       List<User> users=  iUserDao.findUserByName("%小%");
        for(User user: users){
            System.out.println(user);
        }
    }


}
