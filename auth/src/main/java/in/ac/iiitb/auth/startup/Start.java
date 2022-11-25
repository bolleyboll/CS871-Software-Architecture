package in.ac.iiitb.auth.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import in.ac.iiitb.auth.models.Student;
import in.ac.iiitb.auth.models.Teacher;
import in.ac.iiitb.auth.repositories.StudentRepository;
import in.ac.iiitb.auth.repositories.TeacherRepository;

@Component
public class Start {

	@Autowired
	StudentRepository sr;

	@Autowired
	TeacherRepository tr;

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

			Teacher t = new Teacher();
			t.setTeacherId(1);
			t.setName("Chandrashekhar Ramanathan");
			t.setEmail("rc@iiitb.ac.in");
			t.setUsername("rc");
			t.setPassword("password");
			tr.save(t);
		} catch (Exception e) {
			System.out.println("Already Existing data");
		}
	}
}