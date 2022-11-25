package in.ac.iiitb.auth.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin
@RequestMapping("auth")
public class AppController {

	@Autowired
	StudentRepository sr;

	@Autowired
	TeacherRepository tr;

	@PostMapping("slogin")
	public Response StudentLogin(@RequestBody StudentDTO user) {
		Student s = sr.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			return Response.ok("Login Success").build();
		}
		return Response.ok("Invalid Credentials").build();
	}

	@PostMapping("tlogin")
	public Response teacherLogin(@RequestBody @Autowired TeacherDTO user) {
		Teacher s = tr.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			return Response.ok("Login Success").build();
		}
		return Response.ok("Invalid Credentials").build();
	}
}