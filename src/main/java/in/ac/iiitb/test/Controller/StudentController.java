package in.ac.iiitb.test.Controller;

//import javax.ws.rs.Produces;


//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import in.ac.iiitb.test.dto.StudentDTO;
import in.ac.iiitb.test.models.Student;
import in.ac.iiitb.test.services.StudentService;

@RestController
@CrossOrigin
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentService ss;

	@PostMapping("login")
	//@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Student> studentLogin(@RequestBody Student user) {

		Student s = ss.findByUsername(user.getUsername());

		if (s.getPassword().equals(user.getPassword())) {
			Boolean res = ss.setSessionKey("student", s);
			if (res) {
				return ResponseEntity.ok(s);
			} else {
				return ResponseEntity.ok(new Student());
			}
		}
		return ResponseEntity.ok(new Student());
	}

	@GetMapping("test")
	public ResponseEntity<String> getTest(@RequestBody Student user) {

		String uname = ss.getSessionKey("student");
		Student s = ss.findByUsername(uname);

		if (s.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok("Login Success");
		}
		return ResponseEntity.ok("Invalid Credentials");
	}
}