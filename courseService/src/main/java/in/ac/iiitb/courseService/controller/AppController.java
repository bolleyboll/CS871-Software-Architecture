package in.ac.iiitb.courseService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iiitb.courseService.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("course")
public class AppController {

	@Autowired
	CourseService cs;

	
}