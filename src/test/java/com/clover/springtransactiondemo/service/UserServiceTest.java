package com.clover.springtransactiondemo.service;

import com.clover.springtransactiondemo.dao.UserDao;
import com.clover.springtransactiondemo.entity.User;
import com.clover.springtransactiondemo.service.serviceImpl.UserServiceImp;
import com.clover.springtransactiondemo.service.serviceImpl.UserServiceImp2;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.*;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserServiceImp userServiceImp;

    @Test
    public void test() {
        userServiceImp.addUser();
    }
}