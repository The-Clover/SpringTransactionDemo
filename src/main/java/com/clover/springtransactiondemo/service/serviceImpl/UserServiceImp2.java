package com.clover.springtransactiondemo.service.serviceImpl;

import com.clover.springtransactiondemo.dao.UserDao;
import com.clover.springtransactiondemo.entity.User;
import com.clover.springtransactiondemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @program: SpringTransactionDemo
 * @description: 用户服务实现类2
 * @author: Clover
 * @create: 2022/03/21 15:03
 */
@Service("userServiceImp2")
public class UserServiceImp2 implements UserService {

    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void addUser() {
        User user = new User();
        user.setId(2);
        user.setName("法外狂徒李四");
        user.setTag("二号");
        userDao.insertUser(user);
        user.setTag("二号");
        userDao.insertUser(user);
    }
}
