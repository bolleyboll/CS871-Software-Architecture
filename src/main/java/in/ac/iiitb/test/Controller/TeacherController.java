package in.ac.iiitb.test.Controller;

//import javax.ws.rs.Produces;


//import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import in.ac.iiitb.teacherService.dto.TeacherDTO;
import in.ac.iiitb.test.models.Teacher;
import in.ac.iiitb.test.services.TeacherService;

@RestController
@CrossOrigin
@RequestMapping("teacher")
public class TeacherController {

	@Autowired
	TeacherService ts;

	@PostMapping("login")
	//@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Teacher> studentLogin(@RequestBody Teacher user) {

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