package com.clover.springtransactiondemo.dao.provider;

import com.clover.springtransactiondemo.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @program: SpringTransactionDemo
 * @description: 用户DAO Provider
 * @author: Clover
 * @create: 2022/03/21 10:12
 */
public class UserDaoProvider {
    public String insertUser(User user) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if (null != user.getId()) {
                    VALUES("id", "#{id}");
                }
                if (null != user.getName()) {
                    VALUES("name", "#{name}");
                }
                if (null != user.getTag()) {
                    VALUES("tag", "#{tag}");
                }
            }
        }.toString();
    }
}
