package jdbcStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/* DB 접속 객체
	 * DB Driver, url, user, password
	 * com.mysql.cj.jdbc.Driver -> mysql Driver
	 * jdbc:mysql://localhost:3306/DB명 -> url
	 * */
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
	
	//생성자
	private DatabaseConnection() {
		try {
			// 드라이버를 로드하기 위한 메서드
			Class.forName(jdbcDriver);
			// 연결을 위해서 url, userm password
			conn = DriverManager.getConnection(jdbcUrl, "javaUser", "mysql");
			//try~catch를 하지말고 catch만 추가적으로 실행
		} catch (ClassNotFoundException e) {
			// 드라이버를 찾을 수 없는 경우
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// conn 연결정보가 잘못되었을 경우
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
		
	}

	// dbc, conn의 getter만 가지고 오기
	public static DatabaseConnection getDbc() {
		return dbc;
	}

	public Connection getConn() {
		return conn;
	}
	
}
