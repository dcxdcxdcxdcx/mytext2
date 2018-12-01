import com.dcx.dao.UserDao;
import com.dcx.pojo.QueryVo;
import com.dcx.pojo.User;
import com.dcx.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class DbTest {
    @Test
    public void fun01() throws Exception {
        //1. 读取SqlMapConfig.xml获得输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        //3. 获得SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得UserDao代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.调用方法
        List<User> list = userDao.findAll();
        System.out.println(list);
        //6.释放资源
        sqlSession.close();
    }
    @Test
    public void fun02() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User("演员老幺","男",new Date(),"河南");
        userDao.save(user);
        System.out.println("uid="+user.getUid());
        sqlSession.commit();

        //6.释放资源
        sqlSession.close();
    }
    @Test
    public void fun03() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User("狗东西","女",new Date(),"湖北");
        user.setUid(7);
        userDao.update(user);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void fun04() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        userDao.delete(7);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void fun05() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> list = userDao.findByFirstName("顾%");
        System.out.println(list);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void fun06() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> list = userDao.findByFirstName02("顾");
        System.out.println(list);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void fun07() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUid(2);
        queryVo.setUser(user);
        List<User> list = userDao.findByQueryVo(queryVo);
        System.out.println(list);

        sqlSession.close();
    }
    @Test
    public void fun08() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);


        User user = userDao.findByUid(6);
        System.out.println(user);


        sqlSession.close();
    }
    @Test
    public void fun09() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUid(3);
        user.setUsername("顾%");
        queryVo.setUser(user);

        List<User> list = userDao.findByQueryVo(queryVo);
        System.out.println(list);

        sqlSession.close();
    }
}