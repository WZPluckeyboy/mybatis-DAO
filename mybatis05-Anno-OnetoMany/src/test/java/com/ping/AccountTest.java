package com.ping;

import com.ping.Dao.IAccountDao;
import com.ping.Dao.IUserDao;
import com.ping.domain.Account;
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
import java.util.List;

public class AccountTest {
    private   InputStream in;
    private   SqlSessionFactory factory;
    private   SqlSession session;
    private IAccountDao iAccountDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
       iAccountDao= session.getMapper(IAccountDao.class);
    }
    @After
    public void destory() throws  Exception{
        session.close();
        in.close();
    }
    //查询全部
    @Test
    public void findAllTest(){
        List<Account> accounts = iAccountDao.findAll();
        for (Account account: accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
