package com.clover.springtransactiondemo.service.serviceImpl;

import com.clover.springtransactiondemo.dao.UserDao;
import com.clover.springtransactiondemo.entity.User;
import com.clover.springtransactiondemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLTransactionRollbackException;

/**
 * @program: SpringTransactionDemo
 * @description: 用户服务实现类
 * @author: Clover
 * @create: 2022/03/21 10:22
 */

@Service("userServiceImp")
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserServiceImp2 userServiceImp2;

    // SpringTest 默认自动回滚事务，测试时关闭
    //@Rollback(value = false)

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void addUser() {
        try {
            User user = new User();
            user.setId(1);
            user.setName("法外狂徒张三");

            user.setTag("一号");
            userDao.insertUser(user);

/*            userServiceImp2.addUser();

            user.setTag("二号");*/
            userDao.insertUser(user);
        } catch (Exception e) {
            // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
