package com.ping.Dao;

import com.ping.domain.QueryVo;
import com.ping.domain.Users;

import java.util.List;

public interface IUsersDao {
    //查询所有
    public List<Users> findAll();
    //根据id查
    public Users findById(Integer id);
    //根据name查
   public List<Users> findByName(String username);
   //根据传入的参数条件查询,有可能有姓名,有可能有地址,有可能都拥有
   public List<Users> findUserByCondition(Users user);
   public  List<Users> findUserInIds(QueryVo vo);

}
