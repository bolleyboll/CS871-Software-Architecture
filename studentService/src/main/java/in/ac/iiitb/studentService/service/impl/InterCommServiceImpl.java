package in.ac.iiitb.studentService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ac.iiitb.studentService.dto.CourseDTO;
import in.ac.iiitb.studentService.models.Student;
import in.ac.iiitb.studentService.service.InterCommService;

@Service
public class InterCommServiceImpl implements InterCommService{

	public String courseBaseURL = "http://course-service";

	@Override
	public List<CourseDTO> getCourses(Student s) {
		return null;
	}
	
}