package com.nidong.test.service;

import com.nidong.test.dao.AccountDAO;
import com.nidong.test.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public List<Account> getAll() {
        return accountDAO.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int toMonkey() {
        accountDAO.subMonkey();//小东先转出1000

        accountDAO.addMonkey();//小星再接收1000
        return 0;
    }

//    public Account getAccount(String aname) {
//        return accountDAO.getAccount(aname);
//    }
//
//    public void insert(Account account) {
//        accountDAO.insert(account);
//    }
//
//    public void update(Account account) {
//        accountDAO.update(account);
//    }
}
