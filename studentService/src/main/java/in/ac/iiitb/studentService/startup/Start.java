package in.ac.iiitb.studentService.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import in.ac.iiitb.studentService.models.Student;
import in.ac.iiitb.studentService.repositories.StudentRepository;

@Component
public class Start {

	@Autowired
	StudentRepository sr;

	@EventListener(ContextRefreshedEvent.class)
	void start() throws Exception {
		try {
			Student s = new Student();
			s.setStudentId(1);
			s.setName("Aman");
			s.setEmail("aman.gupta@iiitb.ac.in");
			s.setUsername("amang");
			s.setPassword("password");
			sr.save(s);
		} catch (Exception e) {
			System.out.println("Already Existing data");
		}
	}
}