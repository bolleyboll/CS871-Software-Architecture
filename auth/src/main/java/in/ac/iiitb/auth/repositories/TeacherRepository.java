package in.ac.iiitb.auth.repositories;

import in.ac.iiitb.auth.models.Student;
import in.ac.iiitb.auth.models.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}