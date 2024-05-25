package exam01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Ex01 {
    @Test
    void test1() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@localhost:1521:EE";
        String user = "STUDY";
        String password = "oracle";

        try (Connection conn = DriverManager.getConnection(url,user,password);
        Statement stmt = conn.createStatement()) {
            String sql= "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, MOBILE) VALUES(SEQ_MEMBER.NEXTVAL, 'USER01', '123455', '사용자01', '01000000000')";

            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void test2() {
        try {
            Class.forName("oracle.jdbc.oracle.driver.Oracledriver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@localhost:1521:EE";
        String user = "STUDY";
        String password = "oracle";

        try(Connection conn = DriverManager.getConnection(url,user,password);
        Statement stmt = conn.createStatement()){
            String sql = "SELECT USER_NO, USER_ID FROM MEMBER";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                long userNo = rs.getLong("USER_NO");
                String userId = rs.getString("USER_ID");
                System.out.printf("USER_NO:%d, USER_ID:%s%n", userNo, userId);
            }
            rs.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
