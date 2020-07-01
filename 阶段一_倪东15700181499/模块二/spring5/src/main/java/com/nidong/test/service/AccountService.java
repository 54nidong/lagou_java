package com.nidong.test.service;

import com.nidong.test.entity.Account;

import java.util.List;

public interface AccountService {

//    Account getAccount(String name);
//
//    void insert(Account account);
//
//    void update(Account account);

    List<Account> getAll();//查询全部

    int toMonkey();//转账
}
