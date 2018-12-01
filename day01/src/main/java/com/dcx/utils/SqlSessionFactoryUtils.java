package com.dcx.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    public static SqlSessionFactory sqlSessionFactory;

    static{
        InputStream is = null;
        try {
            //读取SqlMapConfig
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //构建sqlSessionFactory
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /**
     * 获得Session
     * @return
     */
    public static SqlSession openSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return  sqlSession;
    }
}
