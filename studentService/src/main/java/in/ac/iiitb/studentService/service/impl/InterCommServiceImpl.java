package in.ac.iiitb.studentService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ac.iiitb.studentService.dto.CourseDTO;
import in.ac.iiitb.studentService.models.Student;
import in.ac.iiitb.studentService.service.InterCommService;

@Service
public class InterCommServiceImpl implements InterCommService{

	@Autowired
	RestTemplate restTemplate;

	public String courseBaseURL = "http://course-service";

	@Override
	public List<CourseDTO> getCourses(Student s) {
		return null;
	}
	
}