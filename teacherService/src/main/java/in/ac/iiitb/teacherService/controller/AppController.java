package in.ac.iiitb.teacherService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iiitb.teacherService.dto.TeacherDTO;
import in.ac.iiitb.teacherService.models.Teacher;
import in.ac.iiitb.teacherService.service.TeacherService;

@RestController
@RequestMapping("teacher")
public class AppController {

	@Autowired
	TeacherService ts;

	@PostMapping("login")
	public ResponseEntity<String> studentLogin(@RequestBody TeacherDTO user) {

		Teacher s = ts.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			Boolean res = ts.setSessionKey("student", s);
			if (res) {
				return ResponseEntity.ok("Login Success");
			} else {
				return ResponseEntity.ok("Login Failed");
			}
		}
		return ResponseEntity.ok("Invalid Credentials");
	}
}