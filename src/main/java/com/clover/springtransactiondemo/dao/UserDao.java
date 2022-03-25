package com.clover.springtransactiondemo.dao;

import com.clover.springtransactiondemo.dao.provider.UserDaoProvider;
import com.clover.springtransactiondemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @program: SpringTransactionDemo
 * @description: 用户DAO
 * @author: Clover
 * @create: 2022/03/21 10:08
 */
@Repository
@Mapper
public interface UserDao {
    @InsertProvider(type = UserDaoProvider.class, method = "insertUser")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);
}
