package configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("mappers")
@EnableTransactionManagement // 이게 뭐지?
public class DBConfig {

    @Bean(destroyMethod = "close") // 자원해제가 되고나서 해제된다.
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        /* DB 연결 설정 S */
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:EE");
        ds.setUsername("SPRING");
        ds.setPassword("oracle");
        /* DB 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setTestWhileIdle(true); // 유휴 객체 유효성 체크
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000); // 10초에 한번씩 연결 상태 체크
        ds.setMinEvictableIdleTimeMillis(1000 * 60); // 유휴 객체 유지 시간 1분
        /* 커넥션 풀 설정 E */

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }

    @Bean // 이객 체를 만들고 설정인 dataSource를 넣고, sessionfactory객체 생성하면된다
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        return sqlSessionFactory;
    }
}
