package in.ac.iiitb.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iiitb.auth.models.Student;
import in.ac.iiitb.auth.repositories.StudentRepository;

@RestController
@CrossOrigin
@RequestMapping("auth")
public class AppController {
	
	@Autowired
	StudentRepository sr;

	@GetMapping("login")
	public String saveStudent(){
		
	}

	@GetMapping("student")
	public String getStudent(){
		
	}
}