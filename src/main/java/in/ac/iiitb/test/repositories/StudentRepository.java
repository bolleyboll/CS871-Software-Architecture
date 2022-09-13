package in.ac.iiitb.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.test.models.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	Student findByStudentId(Integer id);

	boolean deleteByStudentId(Integer id);

	Student findByUsernameAndPassword(String username, String password);
}