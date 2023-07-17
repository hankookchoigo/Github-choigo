import java.sql.*;
import java.util.Scanner;

public class DataBaseLoading {
    Scanner scan = new Scanner(System.in);
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost/javadb";
    Connection conn;
    
    PreparedStatement pstmt;
    ResultSet rs;
    
    // 이벤트 등록 메서드
    public DataBaseLoading() {
        System.out.println("## 이벤트 등록을 위해 이름과 이메일을 입력하세요.");
        System.out.println("이름: ");
        String pname = scan.next();
        int price = scan.nextInt();
        
        connectDB();
        registUser(pname, price);
        printList();
        closeDB();
    }
    
    // DB 연결 메서드
    public void connectDB() {
        try {
            // 1단계 : JDBC 드라이버 로드
            Class.forName(jdbcDriver);
            
            // 2단계 : 데이터베이스 연결
            conn = DriverManager.getConnection(jdbcUrl, "Kiosk", "xhdxhddl11111!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    // 이벤트 등록 메서드
    public void registUser(String pname, int price) {
        String sql = "insert into event values(?, ?)";
        try {
            // 3단계 : Statement 생성
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pname);
            pstmt.setInt(2, price);
            
            // 4단계 : SQL 문 전송
            pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    // 출력 메서드
    public void printList() {
        System.out.println("# 등록자 명단");
        String sql = "select * from event";
        try {
            pstmt = conn.prepareStatement(sql);
            
            // 5단계 : 결과받기
            rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("pname") + ", " + rs.getString(2));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    // DB 연결 종료 메서드
    public void closeDB() {
        try {
            // 6단계 : 연결 해제
            pstmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
