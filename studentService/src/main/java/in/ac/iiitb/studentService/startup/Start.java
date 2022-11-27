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
			s.setName("Aman Gupta");
			s.setEmail("aman.gupta@iiitb.ac.in");
			s.setUsername("amang");
			s.setPassword("password");
			sr.save(s);

			Student s1 = new Student();
			s1.setStudentId(2);
			s1.setName("Nitin Vohra");
			s1.setEmail("nitin.vohra@iiitb.ac.in");
			s1.setUsername("nitinv");
			s1.setPassword("password");
			sr.save(s1);

			Student s2 = new Student();
			s2.setStudentId(3);
			s2.setName("Vishal Govil");
			s2.setEmail("vishal.govil@iiitb.ac.in");
			s2.setUsername("vishalg");
			s2.setPassword("password");
			sr.save(s2);
		} catch (Exception e) {
			System.out.println("Already Existing data");
		}
	}
}