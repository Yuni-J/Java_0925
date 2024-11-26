package jdbcStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements DAO {
	/* DAO <-> DB */
	
	private Connection conn;  // DB 연결객체
	private PreparedStatement pst;  // sql 구문 실행시키는 기능을 가진 객체
	private String query = "";  // 쿼리문 저장 스트링
	
	public StudentDAOImpl() {
		// DBConnection class 생성(싱글톤) 연결
		DatabaseConnection dbc = DatabaseConnection.getDbc();
		conn = dbc.getConn();
	}
	
	// sql 처리
	@Override
	public int insert(Student s) {
		// student 객체를 등록하고, isOk를 리턴
		query = "insert into student(sname, snum, sbirth, sphone, saddr) "
				+ "values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, s.getSname());
			pst.setString(2, s.getSnum());
			pst.setString(3, s.getSbirth());
			pst.setString(4, s.getSphone());
			pst.setString(5, s.getSaddr());
			// 결과의 행 수만 리턴 => executeUpdate();  int로 리턴
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert error!!");
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public List<Student> selectList() {
		query = "select * from student order by sno desc";
		List<Student> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Student(
						rs.getInt("sno"),
						rs.getString("sname"),
						rs.getString("snum")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("list error!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student selectStudent(String snum) {
		query = "select * from student where snum = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, snum);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Student s = new Student(
						rs.getInt("sno"),
						rs.getString("sname"),
						rs.getString("snum"),
						rs.getString("sbirth"),
						rs.getString("sphone"),
						rs.getString("saddr"),
						rs.getString("regdate"));
				return s;
			}
			
		} catch (SQLException e) {
			System.out.println("student error!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Student s) {
		query = "update student set sphone=?, saddr=? where snum=?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, s.getSphone());
			pst.setString(2, s.getSaddr());
			pst.setString(3, s.getSnum());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String snum) {
		query = "delete from student where snum = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, snum);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete error!!");
			e.printStackTrace();
		}
		return 0;
	}

}
