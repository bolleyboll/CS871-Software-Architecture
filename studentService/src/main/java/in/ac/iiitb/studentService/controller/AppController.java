package in.ac.iiitb.studentService.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iiitb.studentService.dto.StudentDTO;
import in.ac.iiitb.studentService.models.Student;
import in.ac.iiitb.studentService.repositories.StudentRepository;
import lombok.Data;

@RestController
@CrossOrigin
@RequestMapping("student")
public class AppController {

	@Autowired
	StudentRepository sr;

	@PostMapping("login")
	public ResponseEntity<String> StudentLogin(@RequestBody StudentDTO user) {

		Student s = sr.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok("Login Success");
		}
		return ResponseEntity.ok("Invalid Credentials");
	}
}