package com.nidong.test.service;

import com.nidong.test.dao.AccountDAO;
import com.nidong.test.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service//@Service用于标注业务层组件
public class AccountServiceImpl implements AccountService {

    /**
     * Spring 2.5 引入了 @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
     */
    @Autowired
    private AccountDAO accountDAO;

    public List<Account> getAll() {
        return accountDAO.getAll();
    }

    /**
     * 显然声明式事务管理要优于编程式事务管理，这正是spring倡导的非侵入式的开发方式。声明式事务管理使业务代码不受污染，一个普通的POJO对象，只要加上注解就可以获得完全的事务支持。和编程式事务相比，声明式事务唯一不足地方是，后者的最细粒度只能作用到方法级别，无法做到像编程式事务那样可以作用到代码块级别。但是即便有这样的需求，也存在很多变通的方法，比如，可以将需要进行事务管理的代码块独立为方法等等。
     * 声明式事务管理也有两种常用的方式，一种是基于tx和aop名字空间的xml配置文件，另一种就是基于@Transactional注解。显然基于注解的方式更简单易用，更清爽。
     * */
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
