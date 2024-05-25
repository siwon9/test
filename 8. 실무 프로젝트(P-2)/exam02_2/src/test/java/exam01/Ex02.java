package exam01;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;
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
        String userId = "UEER_04";
        String userPw = "123456";
        String userNm = "사용자04";
        String mobile = "01000000000";

        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, MOBILE) VALUES(SEQ_MEMBER.NEXTVAL, ?,?,?,?)";
        try(Connection conn =DriverManager.getConnection(url,user,password);
        PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"USER_NO"})) {

            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);
            pstmt.setString(3, userNm);
            pstmt.setString(4, mobile);

            int cnt = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()) {
                long userNo = rs.getLong(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
