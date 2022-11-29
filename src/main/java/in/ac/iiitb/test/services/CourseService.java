package in.ac.iiitb.test.services;

import java.util.ArrayList;

import java.util.List;

import in.ac.iiitb.test.models.Course;
import in.ac.iiitb.test.models.CourseRegistration;
import in.ac.iiitb.test.models.Exam;
import in.ac.iiitb.test.models.ExamResponse;

public interface CourseService {
	public List<CourseRegistration> getTests(String student);
	ArrayList<Exam> findByCourseCode(Course c);
	ExamResponse saveTestResponse(ExamResponse examResp);
	Exam saveExam(Exam exam);
	List<Course> allCourses();
}
