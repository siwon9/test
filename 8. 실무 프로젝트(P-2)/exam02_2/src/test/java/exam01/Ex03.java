package exam01;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.jdbc.SQL;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class Ex03 {
    @Test
    void test1() {
        // 커넥션 풀
        DataSource ds = new DataSource();
        // 연결설정
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:EE");
        ds.setUsername("STUDY");
        ds.setPassword("oracle");
        //커넥션 풀 설정
        ds.setInitialSize(2); // 로드 초기에 생성할 갯수 - 기본값 10
        ds.setMaxActive(10); // 최대생성할 객체 수 - 기본값 100
        ds.setTestWhileIdle(true); // 연결 객체가 유휴상태일 때 연결상태 체크
        ds.setTimeBetweenEvictionRunsMillis(5 * 1000); // 5초에 한번씩연결상태 체크
        ds.setMinEvictableIdleTimeMillis(30 * 1000); //유휴상태인 객체를 30초 이후에 소멸 후 생성한다.
        //Connection 객체 생성
        try(Connection conn = ds.getConnection()) {

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void test2(){
        //커넥션 풀
        HikariConfig config = new HikariConfig();
        //연결 설정
        config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:EE");
        config.setUsername("STUDY");
        config.setPassword("oracle");
        //커넥션 풀 설정
        config.setMinimumIdle(2);
        config.setMaximumPoolSize(10);
        //DataSource 객체생성
        HikariDataSource ds = new HikariDataSource(config);

    }
}
