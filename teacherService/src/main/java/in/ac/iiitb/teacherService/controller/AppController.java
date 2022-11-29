package in.ac.iiitb.teacherService.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Teacher> studentLogin(@RequestBody TeacherDTO user) {

		Teacher t = ts.findByUsername(user.getUsername());

		if (t.getPassword().equals(user.getPassword())) {
			Boolean res = ts.setSessionKey("teacher", t);
			if (res) {
				return ResponseEntity.ok(t);
			} else {
				return ResponseEntity.ok(new Teacher());
			}
		}
		return ResponseEntity.ok(new Teacher());
	}
}