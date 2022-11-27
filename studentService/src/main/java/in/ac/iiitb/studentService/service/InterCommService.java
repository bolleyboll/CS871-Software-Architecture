package in.ac.iiitb.studentService.service;

import java.util.List;

import in.ac.iiitb.studentService.dto.CourseDTO;
import in.ac.iiitb.studentService.models.Student;

public interface InterCommService {
	List<CourseDTO> getCourses(Student s);
}
