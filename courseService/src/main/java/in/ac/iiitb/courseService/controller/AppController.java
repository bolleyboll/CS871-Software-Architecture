package in.ac.iiitb.courseService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.ac.iiitb.courseService.intercomm.StudentClient;
import in.ac.iiitb.courseService.service.CourseService;

@RestController
@RequestMapping("course")
public class AppController {

	@Autowired
	CourseService cs;

	@Autowired
	StudentClient sc;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("abc")
	public ResponseEntity<String> findStudentsOfCourse() {
		String s = sc.getStr();
		return ResponseEntity.ok(s);
	}
}