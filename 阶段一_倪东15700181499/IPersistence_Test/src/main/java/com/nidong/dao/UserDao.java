package com.nidong.dao;

import com.nidong.entity.User;

import java.util.List;
/**
 * @author nidong
 * Created on 2020-01-27
 */
public interface UserDao {
    List<User> findAll();

    User findByCondition(User user);

    Integer update(User user);

    Integer delete(Integer id);
}
