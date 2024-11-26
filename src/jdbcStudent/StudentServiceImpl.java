package jdbcStudent;

import java.util.List;

public class StudentServiceImpl implements Service {
	/* service <-> DAO */
	// 생성자로 DAO 객체와 연결
	private DAO dao;  //interface
	
	public StudentServiceImpl(){
		dao = new StudentDAOImpl();  //DAO 구현체
	}

	@Override
	public int insert(Student s) {
		//DAO에게 DB 저장을 요청
		// dao 요청시 메서드명은 sql구문과 비슷하게 작성하는 것이 일반적
		return dao.insert(s);
	}

	@Override
	public List<Student> getList() {
		return dao.selectList();
	}

	@Override
	public Student searchStudent(String snum) {
		return dao.selectStudent(snum);
	}

	@Override
	public int update(Student s) {
		return dao.update(s);
	}

	@Override
	public int delete(String snum) {
		return dao.delete(snum);
	}
	
	

}
