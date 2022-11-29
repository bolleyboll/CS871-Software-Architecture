package in.ac.iiitb.courseService.service;

import java.util.ArrayList;
import java.util.List;

import in.ac.iiitb.courseService.models.Course;
import in.ac.iiitb.courseService.models.CourseRegistration;
import in.ac.iiitb.courseService.models.Exam;

public interface CourseService {
	public List<CourseRegistration> getTests(String student);
	ArrayList<Exam> findByCourseCode(Course c);
}
