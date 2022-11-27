package in.ac.iiitb.courseService.repositories;

import in.ac.iiitb.courseService.models.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
	Course findByUsername(String username);
}