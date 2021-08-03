package com.wuqihu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private SqlSessionUtil(){}
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource ="mybatis.xml";
        InputStream inputStream =null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
    }
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
    public static SqlSession getSession(){
        SqlSession sqlSession =threadLocal.get();
        if (sqlSession == null) {
            sqlSession=sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void myCloss(SqlSession sqlSession){
        if (sqlSession == null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
