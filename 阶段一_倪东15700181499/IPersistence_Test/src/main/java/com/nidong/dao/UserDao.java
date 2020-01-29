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

    void update(User user);

    void delete(Integer id);
}
