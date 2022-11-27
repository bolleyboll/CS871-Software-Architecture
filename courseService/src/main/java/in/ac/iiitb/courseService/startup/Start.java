package in.ac.iiitb.courseService.startup;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import in.ac.iiitb.courseService.models.Course;
import in.ac.iiitb.courseService.models.CourseRegistration;
import in.ac.iiitb.courseService.models.Exam;
import in.ac.iiitb.courseService.repositories.CourseRegistrationRepository;
import in.ac.iiitb.courseService.repositories.CourseRepository;
import in.ac.iiitb.courseService.repositories.ExamRepository;

@Component
public class Start {

	@Autowired
	CourseRepository cr;

	@Autowired
	CourseRegistrationRepository crr;

	@Autowired
	ExamRepository er;

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

			Exam e = new Exam();
			e.setExamId(1);
			e.setName("Architecture Viva");
			e.setDuration(30);
			e.setCourseCode(t);
			e.setStartDate(new Date());
			er.save(e);

			Exam e1 = new Exam();
			e1.setExamId(2);
			e1.setName("Architecture End Term");
			e1.setDuration(180);
			e1.setCourseCode(t);
			e1.setStartDate(new Date());
			er.save(e1);

			Exam e2 = new Exam();
			e2.setExamId(3);
			e2.setName("FSL End Term");
			e2.setDuration(180);
			e2.setCourseCode(t1);
			e2.setStartDate(new Date());
			er.save(e2);

		} catch (Exception e) {
			System.out.println("Already Existing data");
		}
	}
}