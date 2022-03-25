package com.clover.springtransactiondemo.entity;

/**
 * @program: SpringTransactionDemo
 * @description: 用户类
 * @author: Clover
 * @create: 2022/03/21 10:06
 */
public class User {
    private Integer id;
    private String name;
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
