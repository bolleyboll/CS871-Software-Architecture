package in.ac.iiitb.courseService.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.courseService.models.CourseRegistration;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {
	ArrayList<CourseRegistration> findByStudent(String s);
}
