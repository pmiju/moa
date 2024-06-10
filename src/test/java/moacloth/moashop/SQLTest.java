package moacloth.moashop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLTest {
    public static void main(String[] args) {
        Connection conn = null;

        String server = "localhost";
        String user_name = "root";
        String password = "1234";

        // JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        // 접속
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false", user_name, password);
            System.out.println("연결 완료!");
        } catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }

        // 접속 종료
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {}
    }

}

