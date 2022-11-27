package in.ac.iiitb.courseService.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import in.ac.iiitb.courseService.models.Course;
import in.ac.iiitb.courseService.repositories.CourseRepository;

@Component
public class Start {

	@Autowired
	CourseRepository cr;

	@EventListener(ContextRefreshedEvent.class)
	void start() throws Exception {
		try {
			Course t = new Course();
			t.setCourseId(1);
			t.setCourseCode("CS801");
			t.setCourseName("Software Architecture");
			cr.save(t);
		} catch (Exception e) {
			System.out.println("Already Existing data");
		}
	}
}