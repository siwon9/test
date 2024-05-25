package exam01;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class Ex02 {
    private String url = "jdbc.oracle:thin:@localhost:1521:EE";
    private String user = "STUDY";
    private String password = "oracle";

    @BeforeAll
    static void init() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test1() {
        String keyword = "사용자";
        String sql = "SELECT * FROM MEMBER WHERE USER_NM LIKE ?";
        try(Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,"%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next());

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, MOBILE)";
        try(Connection conn =DriverManager.getConnection(url,user,password);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
