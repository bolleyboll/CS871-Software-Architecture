package in.ac.iiitb.courseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.courseService.models.ExamResponse;

public interface ExamResponseRepository extends JpaRepository<ExamResponse, Integer> {
	
}
