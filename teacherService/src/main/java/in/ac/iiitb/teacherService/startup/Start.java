package in.ac.iiitb.teacherService.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import in.ac.iiitb.teacherService.models.Teacher;
import in.ac.iiitb.teacherService.repositories.TeacherRepository;

@Component
public class Start {

	@Autowired
	TeacherRepository tr;

	@EventListener(ContextRefreshedEvent.class)
	void start() throws Exception {
		try {
			Teacher t = new Teacher();
			t.setTeacherId(1);
			t.setName("Chandrashekhar Ramanathan");
			t.setEmail("rc@iiitb.ac.in");
			t.setUsername("rc");
			t.setPassword("password");

			Teacher t1 = new Teacher();
			t1.setTeacherId(2);
			t1.setName("V Ramasubramanian");
			t1.setEmail("v.ramasubramanian@iiitb.ac.in");
			t1.setUsername("ram");
			t1.setPassword("password");
			tr.save(t1);
		} catch (Exception e) {
			System.out.println("Already Existing data");
		}
	}
}