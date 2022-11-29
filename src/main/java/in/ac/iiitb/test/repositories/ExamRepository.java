package in.ac.iiitb.test.repositories;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.test.models.Course;
import in.ac.iiitb.test.models.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
	ArrayList<Exam> findByCourseCode(Course c);
}
