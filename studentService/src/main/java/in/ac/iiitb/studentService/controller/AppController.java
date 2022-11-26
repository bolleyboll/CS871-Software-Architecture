package in.ac.iiitb.studentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iiitb.studentService.dto.StudentDTO;
import in.ac.iiitb.studentService.models.Student;
import in.ac.iiitb.studentService.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("student")
public class AppController {

	@Autowired
	StudentService ss;

	@PostMapping("login")
	public ResponseEntity<String> studentLogin(@RequestBody StudentDTO user) {

		Student s = ss.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			Boolean res = ss.setSessionKey("student", s);
			if (res) {
				return ResponseEntity.ok("Login Success");
			} else {
				return ResponseEntity.ok("Login Failed");
			}
		}
		return ResponseEntity.ok("Invalid Credentials");
	}

	@GetMapping("test")
	public ResponseEntity<String> getTest(@RequestBody StudentDTO user) {

		String uname = ss.getSessionKey("student");
		Student s = ss.findByUsername(uname);

		if (s.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok("Login Success");
		}
		return ResponseEntity.ok("Invalid Credentials");
	}
}