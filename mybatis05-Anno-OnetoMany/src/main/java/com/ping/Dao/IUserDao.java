package com.ping.Dao;

import com.ping.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
//开启二级缓存的注解
@CacheNamespace(blocking = true)
public interface IUserDao {
   @Select("select * from user")
   @Results(id="userMap",value ={@Result(id=true,column ="id",property ="userId"),
           @Result(column ="address" ,property = "userAddress"),
           @Result(column = "username" ,property = "userName"),
           @Result(column = "sex",property = "userSex"),
           @Result(column = "birthday",property = "userBirthday"),
           @Result(property = "accounts",column = "id",
                   many = @Many(select = "com.ping.Dao.IAccountDao.findAccountById",
                           fetchType = FetchType.LAZY))
   })
    List<User> findAll();
   @Select("select * from user where id=#{id}")
   @ResultMap("userMap")
    User findById(Integer userId);
    @Select("select * from  user where username like #{username}")
    @ResultMap("userMap")
   List<User> findUserByName(String username);

}
