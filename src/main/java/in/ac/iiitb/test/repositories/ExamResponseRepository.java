package in.ac.iiitb.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import in.ac.iiitb.test.models.ExamResponse;

public interface ExamResponseRepository extends JpaRepository<ExamResponse, Integer> {
	
}
