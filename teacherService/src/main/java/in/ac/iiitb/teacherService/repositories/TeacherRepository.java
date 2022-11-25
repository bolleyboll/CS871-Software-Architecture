package in.ac.iiitb.teacherService.repositories;

import in.ac.iiitb.teacherService.models.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
	Teacher findByUsername(String username);
}