package in.ac.iiitb.courseService.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.courseService.models.Course;
import in.ac.iiitb.courseService.models.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
	ArrayList<Exam> findByCourseCode(Course c);
}
