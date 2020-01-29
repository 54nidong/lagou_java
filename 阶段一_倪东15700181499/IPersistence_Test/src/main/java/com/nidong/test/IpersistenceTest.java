package com.nidong.test;

import com.nidong.dao.UserDao;
import com.nidong.entity.User;
import org.junit.Test;

import com.nidong.resource.Resources;
import com.nidong.sqlSession.SqlSession;
import com.nidong.sqlSession.SqlSessionFactory;
import com.nidong.sqlSession.SqlSessionFactoryBuilder;
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
}
