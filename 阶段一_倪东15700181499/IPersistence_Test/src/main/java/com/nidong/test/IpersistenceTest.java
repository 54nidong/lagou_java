package com.nidong.test;

import com.nidong.dao.UserDao;
import com.nidong.entity.User;
import org.junit.Test;
import resource.Resources;
import sqlSession.SqlSession;
import sqlSession.SqlSessionFactory;
import sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class IpersistenceTest {
    @Test
    public void test1 () throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        List<User> objectList = sqlSession.selectList("com.zzk.learning.dao.UserDao.findAll");
//        for (User user : objectList) {
//            System.out.println(user);
//        }

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void test2 () throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findByCondition(new User());
        System.out.println(user);
    }

    @Test
    public void test3 () throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        Integer num = mapper.update(user);
        System.out.println(num);
    }

    @Test
    public void test4 () throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Integer num = mapper.delete(1);
        System.out.println(num);
    }
}
