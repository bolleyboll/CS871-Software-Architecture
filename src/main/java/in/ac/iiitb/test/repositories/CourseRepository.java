package in.ac.iiitb.test.repositories;

import in.ac.iiitb.test.models.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
	Course findByCourseCode(String courseCode);
}