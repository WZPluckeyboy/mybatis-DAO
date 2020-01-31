package com.ping.test;
import com.ping.Dao.IRoleDao;
import com.ping.Dao.IUsersDao;
import com.ping.domain.Users;
import com.ping.domain.role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private  InputStream in;
    private   SqlSessionFactoryBuilder build;
    private    SqlSession session;
    private IRoleDao iRoleDao;
    @Before
    public void init()throws Exception{
        //1. 读取配置文件
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工程
       build=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=build.build(in);
        //3.创建SqlSession对象
       session=factory.openSession();
        //4.使用SqlSession对象创建Dao的代理的对象
       iRoleDao=session.getMapper(IRoleDao.class);
        //5.使用代理对象执行方法
    }
    @After
    public void destry() throws  Exception{
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }
    @Test
   public void testFindAll()  {
        List<role> users=iRoleDao.findAll();
        for(role user:users) {
            System.out.println(user);
            System.out.println(user.getUsersList());
        }
    }

}
