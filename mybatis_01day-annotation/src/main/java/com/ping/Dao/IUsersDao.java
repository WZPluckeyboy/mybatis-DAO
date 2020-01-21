package com.ping.Dao;

import com.ping.domain.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUsersDao {
    @Select("select * from users")
    //查询所有
    public List<Users> findAll();

}
