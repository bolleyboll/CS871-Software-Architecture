package in.ac.iiitb.courseService.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import in.ac.iiitb.courseService.models.Course;
import in.ac.iiitb.courseService.models.CourseRegistration;
import in.ac.iiitb.courseService.repositories.CourseRegistrationRepository;
import in.ac.iiitb.courseService.repositories.CourseRepository;

@Component
public class Start {

	@Autowired
	CourseRepository cr;

	@Autowired
	CourseRegistrationRepository crr;

	@EventListener(ContextRefreshedEvent.class)
	void start() throws Exception {
		try {
			Course t = new Course();
			t.setCourseId(1);
			t.setCourseCode("CS801");
			t.setCourseName("Software Architecture");
			cr.save(t);

			Course t1 = new Course();
			t1.setCourseId(2);
			t1.setCourseCode("AI802");
			t1.setCourseName("Few Shot Learning");
			cr.save(t1);

			CourseRegistration creg = new CourseRegistration();
			creg.setId(1);
			creg.setCourse(t);
			creg.setStudent("amang");
			crr.save(creg);

			CourseRegistration creg2 = new CourseRegistration();
			creg2.setId(2);
			creg2.setCourse(t1);
			creg2.setStudent("amang");
			crr.save(creg2);

			CourseRegistration creg3 = new CourseRegistration();
			creg3.setId(3);
			creg3.setCourse(t);
			creg3.setStudent("vishalg");
			crr.save(creg3);

			CourseRegistration creg4 = new CourseRegistration();
			creg4.setId(4);
			creg4.setCourse(t);
			creg4.setStudent("nitinv");
			crr.save(creg4);
			

		} catch (Exception e) {
			System.out.println("Already Existing data");
		}
	}
}