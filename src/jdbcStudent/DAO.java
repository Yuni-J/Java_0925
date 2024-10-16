package jdbcStudent;

import java.util.List;

public interface DAO {

	int insert(Student s);

	List<Student> selectList();

	Student selectStudent(String snum);

	int update(Student s);

	int delete(String snum);

}
