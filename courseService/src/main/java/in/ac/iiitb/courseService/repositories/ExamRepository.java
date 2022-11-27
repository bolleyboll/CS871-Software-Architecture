package in.ac.iiitb.courseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.courseService.models.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
	
}
