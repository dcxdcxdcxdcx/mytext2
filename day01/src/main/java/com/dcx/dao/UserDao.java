package com.dcx.dao;

import com.dcx.pojo.QueryVo;
import com.dcx.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(int uid);
    /**
     * 模糊查询
     */
    List<User> findByFirstName(String firstName);
    List<User> findByFirstName02(String firstName);
    /**
     * 复杂参数查询
     */
    List<User> findByQueryVo(QueryVo queryVo);
    int findCount();
    User findByUid(int uid);
}
