package com.clover.springtransactiondemo.service.serviceImpl;

import com.clover.springtransactiondemo.dao.UserDao;
import com.clover.springtransactiondemo.entity.User;
import com.clover.springtransactiondemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: SpringTransactionDemo
 * @description: 用户服务实现类
 * @author: Clover
 * @create: 2022/03/21 10:22
 */

@Service("userServiceImp")
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserServiceImp2 userServiceImp2;

    @Resource
    private ApplicationContext context;

    // SpringTest 默认自动回滚事务，测试时关闭
    //@Rollback(value = false)

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUser() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("法外狂徒张三1");
        userDao.insertUser(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("法外狂徒张三2");
        userDao.insertUser(user2);

        try {
            userServiceImp2.addUser();
        } catch (Exception e)
        {
            System.out.printf("B服务异常：%S%n", e.getMessage());
        }
    }
}
