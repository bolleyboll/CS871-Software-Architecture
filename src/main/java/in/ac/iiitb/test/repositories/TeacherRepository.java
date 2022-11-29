package in.ac.iiitb.test.repositories;

import in.ac.iiitb.test.models.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
	Teacher findByUsername(String username);
}