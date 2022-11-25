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
import in.ac.iiitb.teacherService.repositories.TeacherRepository;

@RestController
@CrossOrigin
@RequestMapping("teacher")
public class AppController {

	@Autowired
	TeacherRepository tr;

	@PostMapping("login")
	public ResponseEntity<String> teacherLogin(@RequestBody TeacherDTO user) {
		Teacher s = tr.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok("Login Success");
		}
		return ResponseEntity.ok("Invalid Credentials");
	}
}