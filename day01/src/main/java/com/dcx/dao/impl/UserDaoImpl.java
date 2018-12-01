package com.dcx.dao.impl;

import com.dcx.dao.UserDao;
import com.dcx.pojo.QueryVo;
import com.dcx.pojo.User;
import com.dcx.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public List<User> findAll() {

        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        List<User> list = sqlSession.selectList("test.findAll");
        sqlSession.close();
        return list;
    }

    public void save(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        sqlSession.insert("test.save",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        sqlSession.update("test.update",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int uid) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        sqlSession.delete("test.delete",uid);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<User> findByFirstName(String firstName) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        List<User> list = sqlSession.selectList("test.findByFirstName",firstName);
        sqlSession.close();
        return list;
    }

    public List<User> findByFirstName02(String firstName) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        List<User> list = sqlSession.selectList("test.findByFirstName02",firstName);
        sqlSession.close();
        return list;
    }

    public List<User> findByQueryVo(QueryVo queryVo) {
        return null;
    }

    public int findCount() {
        return 0;
    }

    public User findByUid(int uid) {
        return null;
    }
}
