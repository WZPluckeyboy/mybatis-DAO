package com.ping.test;
import com.ping.Dao.IUsersDao;
import com.ping.domain.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    private  InputStream in;
    private   SqlSessionFactoryBuilder build;
    private    SqlSession session;
    private   IUsersDao usersDao;
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
       usersDao=session.getMapper(IUsersDao.class);
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
        List<Users> users=usersDao.findAll();
        for(Users user:users){
            System.out.println(user);
        }
    }
    //测试保存操作
    @Test
    public void testSave() {
     Users users=new Users();
     users.setUserId(15);
     users.setUserName("张三");
     users.setUserAddr("Japan");
     //5.执行保存方法
        usersDao.saveUser(users);
    }
    // 测试更新操作
    @Test
    public void testUpdate() {
        Users users=new Users();
        users.setUserId(5);
        users.setUserName("张三");
        users.setUserAddr("Japan");
        //5.执行更新方法
        usersDao.updateUser(users);
    }
    //测试删除操作
    // 测试更新操作
    @Test
    public void testDelet() {
        //5.执行删除方法
        usersDao.deletUser(4);
    }
    //测试查询一个
    @Test
    public void testFindById()  {
        Users users=usersDao.findById(3);
        System.out.println(users);
    }
    @Test
    public void testFindByName(){
        List<Users> list=usersDao.findByName("王");
        for(Users users : list){
            System.out.println(users);
        }
    }
    @Test
    //查询总记录条数
    public void testFindCount(){

        int count =usersDao.findTota();
        System.out.println(count);
    }

}
