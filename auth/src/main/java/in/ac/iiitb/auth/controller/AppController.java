package in.ac.iiitb.auth.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iiitb.auth.dto.StudentDTO;
import in.ac.iiitb.auth.dto.TeacherDTO;
import in.ac.iiitb.auth.models.Student;
import in.ac.iiitb.auth.models.Teacher;
import in.ac.iiitb.auth.repositories.StudentRepository;
import in.ac.iiitb.auth.repositories.TeacherRepository;
import lombok.Data;

@RestController
@CrossOrigin
@RequestMapping("auth")
public class AppController {

	@Autowired
	StudentRepository sr;

	@Autowired
	TeacherRepository tr;

	@PostMapping("/student/login")
	public ResponseEntity<String> StudentLogin(@RequestBody StudentDTO user) {

		Student s = sr.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok("Login Success");
		}
		return ResponseEntity.ok("Invalid Credentials");
	}

	@PostMapping("/teacher/login")
	public ResponseEntity<String> teacherLogin(@RequestBody TeacherDTO user) {
		Teacher s = tr.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok("Login Success");
		}
		return ResponseEntity.ok("Invalid Credentials");
	}
}