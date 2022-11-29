package in.ac.iiitb.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import in.ac.iiitb.test.models.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	Student findByUsername(String username);
}
