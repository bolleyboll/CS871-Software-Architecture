package in.ac.iiitb.studentService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.studentService.models.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	Student findByUsername(String username);
}
