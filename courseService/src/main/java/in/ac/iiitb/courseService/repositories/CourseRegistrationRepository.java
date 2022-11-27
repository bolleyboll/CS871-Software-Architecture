package in.ac.iiitb.courseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.courseService.models.CourseRegistration;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {
	
}
