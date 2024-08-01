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

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addUser() {
        User user3 = new User();
        user3.setId(3);
        user3.setName("法外狂徒张三3");
        userDao.insertUser(user3);

        User user4 = new User();
        user4.setId(3);
        user4.setName("法外狂徒张三4");
        userDao.insertUser(user4);
    }
}
