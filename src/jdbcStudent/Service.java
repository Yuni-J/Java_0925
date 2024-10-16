package jdbcStudent;

import java.util.List;

public interface Service {

	int insert(Student s);

	List<Student> getList();

	Student searchStudent(String snum);

	int update(Student s);

	int delete(String num);

}
