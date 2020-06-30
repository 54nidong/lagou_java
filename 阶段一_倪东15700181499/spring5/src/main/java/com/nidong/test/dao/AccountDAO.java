package com.nidong.test.dao;

import com.nidong.test.entity.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountDAO {

//    Account getAccount(String name);
//
//    void insert(Account account);
//
//    void update(Account account);

      @Select("select * from account")
      List<Account> getAll();//查询数据库中所有信息

      @Update("update account set money=money+1000 where aname=\"小东\"")
      int addMonkey();//给aname=小东的用户加1000块钱

      @Update("update account set money=money-1000 where aname=\"小星\"")
      int subMonkey();//给aname=小星的用户减1000块钱
}
