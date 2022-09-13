package in.ac.iiitb.test.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.test.models.CourseRegistration;
import in.ac.iiitb.test.models.Student;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {
	ArrayList<CourseRegistration> findByStudent(Student s);
}