package config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class) // 확장기능이 추가되고, 의존성~~
@ContextConfiguration(classes = AppCtx.class) // 이게 뭘까?
public class DBConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void test1() throws Exception{
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
