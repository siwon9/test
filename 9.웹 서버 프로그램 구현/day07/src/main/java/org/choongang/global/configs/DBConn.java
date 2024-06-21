package org.choongang.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
// configs에는 무엇이 들어가나요?  DB에 연결하는 SqlSessionFactory를 생성하고 설정하는 곳

public class DBConn {
    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader
            ("org/choongang/global/configs/mybatis-config.xml");

            factory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public static SqlSession getSession(boolean autoCommit) {
        String mode = System.getenv("mode");
        if (mode != null && mode.equals("test")) autoCommit = false;
            //환경변수가 뭐야??

        return factory.openSession(autoCommit);
    }

    public static SqlSession getSession() {
        return getSession(true);
    }
}

