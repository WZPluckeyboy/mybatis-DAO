package com.ping.Dao;

import com.ping.domain.QueryVo;
import com.ping.domain.Users;

import java.util.List;

public interface IUsersDao {
    //查询所有
    public List<Users> findAll();
    //保存方法
    public void saveUser(Users user);
    //更新方法
    public void updateUser(Users users);
    //根据id删除操作
    public void deletUser(Integer userId);
    //根据id查
    public Users findById(Integer id);
    //根据name查
   public List<Users> findByName(String username);
   //查询总用户数
    public int findTota();
    //根据QueryVo中的条件查询用户
    public  List<Users> findByVo(QueryVo vo);

}
