package org.choongang.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // 트랜젝션 관련 설정이 완료가 된다.
@MapperScan("org.choongang")
@EnableJdbcRepositories("org.choongang")
// Spring Data JDBC를 사용하여 리포지토리를 활성화하고,
// 특정 패키지에서 리포지토리 인터페이스를 검색하고 등록하도록 Spring 컨텍스트에 지시
public class DBConfig extends AbstractJdbcConfiguration {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();

        /* 연결 설정 S */
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:EE");
        ds.setUsername("SPRING");
        ds.setPassword("oracle");
        /* 연결 설정 E */

        /* 커넥션 풀 설정 S */
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(1000 * 60); // 기본 1분
        ds.setTimeBetweenEvictionRunsMillis(1000 * 5); // 기본 5분
        /* 커넥션 풀 설정 E */

        return ds;
    }

    @Bean //외부에서 가져온건 다 수동 등록을 해줘야한다.
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        return factoryBean.getObject();
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

}



