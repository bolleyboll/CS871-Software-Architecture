package in.ac.iiitb.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.auth.models.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	Student findByUsername(String username);
}
