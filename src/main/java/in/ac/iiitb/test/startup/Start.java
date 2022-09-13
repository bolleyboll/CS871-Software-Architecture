package in.ac.iiitb.test.startup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import in.ac.iiitb.test.models.CourseRegistration;
import in.ac.iiitb.test.models.Student;
import in.ac.iiitb.test.models.Subject;
import in.ac.iiitb.test.models.Test;
import in.ac.iiitb.test.repositories.CourseRegistrationRepository;
import in.ac.iiitb.test.repositories.StudentRepository;
import in.ac.iiitb.test.repositories.SubjectRepository;
import in.ac.iiitb.test.repositories.TestRepository;

@Component
public class Start {

	@Autowired
	TestRepository tr;

	@Autowired
	StudentRepository sr;

	@Autowired
	SubjectRepository subr;

	@Autowired
	CourseRegistrationRepository crr;

	void studentLogin() throws Exception {
		String uname, pass;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter username: ");
		uname = br.readLine();

		System.out.print("Enter password: ");
		pass = br.readLine();

		Student s = sr.findByUsernameAndPassword(uname, pass);

		if (s.getUsername().equalsIgnoreCase(uname)) {
			System.out.println("Login Scucessfull");

			List<CourseRegistration> courses = crr.findByStudent(s);
			ArrayList<Subject> subs = new ArrayList<Subject>();
			ArrayList<Test> tests = new ArrayList<>();

			for (CourseRegistration cou : courses) {
				subs.add(cou.getCourse());
			}

			for (Subject su : subs) {
				// tests.add(tr.findByCourseCode(s).get(arg0));
				ArrayList<Test> temporary;
				temporary = tr.findByCourseCode(su);

				for (Test t : temporary) {
					tests.add(t);
				}
			}
			int i=1;
			for (Test tes : tests) {
				System.out.println(i++ + ". " + tes.getName());
			}
			System.out.println("Enter your Choice: ");
			i = Integer.parseInt(br.readLine());

		} else {
			System.out.println("Invalid Login Details.");
		}
	}

	void teach() throws Exception {

		int choice;
		
		Test t = new Test();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("---Create a New Test---");

		System.out.println("Enter Test Name:");
		String name;
		name = br.readLine();
		t.setName(name);

		System.out.println("Enter Date of Exam: ");
		int date, month, year, hr, minute;

		System.out.println("Enter Date");
		date = Integer.parseInt(br.readLine());
		System.out.println("Enter Month Number");
		month = Integer.parseInt(br.readLine());
		System.out.println("Enter Year");
		year = Integer.parseInt(br.readLine());
		System.out.println("Enter Hour in 24hr format");
		hr = Integer.parseInt(br.readLine());
		System.out.println("Enter Minute");
		minute = Integer.parseInt(br.readLine());

		String dateString = year + "-" + month + "-" + date + " " + hr + ":" +
				minute;
		System.out.println("Date and Time of the Exam: " +
				dateString);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		Date d = formatter.parse(dateString);
		t.setStartDate(d);

		System.out.println("Enter Duration of the Exam: ");
		int duration;
		duration = Integer.parseInt(br.readLine());
		t.setDuration(duration);

		System.out.println("Enter Subject Code");
		String cc;
		cc = br.readLine();

		Subject sub = subr.findBySubjectCode(cc);
		t.setCourseCode(sub);

		tr.save(t);
	}

	@EventListener(ContextRefreshedEvent.class)
	void te() throws Exception {
		int choice;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Student s = new Student();
		s.setStudentId(1);
		s.setName("Aman");
		s.setEmail("aman.gupta@iiitb.ac.in");
		s.setUsername("amang");
		s.setPassword("password");
		sr.save(s);

		Subject sub = new Subject();
		sub.setSubjectId(1);
		sub.setSubjectName("Software Architecture");
		sub.setSubjectCode("CS801");
		subr.save(sub);

		CourseRegistration cr = new CourseRegistration();
		cr.setId(1);
		cr.setStudent(s);
		cr.setCourse(sub);
		crr.save(cr);

		Date d = new Date();
		Test t = new Test();
		t.setName("Aman Test");
		t.setDuration(180);
		t.setCourseCode(sub);
		t.setStartDate(d);
		t.setTestId(1);
		tr.save(t);

		// System.out.println("1. Student Login\n2. Teacher Login");
		// choice = Integer.parseInt(br.readLine());
		// switch (choice) {
		// 	case 1:
		// 		studentLogin();
		// 		break;
		// 	case 2:
		// 		teach();
		// 		break;
		// 	default:
		// 		System.out.println("Invalid Option");
		// 		break;
		// }
		// System.out.println("Done");
		System.out.println("\n\n---Welcome to OAES---\n\n");
		System.out.println("1. Student Login\n2. Teacher Login");
		System.out.println("Enter your Choice");
		System.out.println("2");
		System.out.println("\n---Create Test---\n");
		System.out.println("Enter Test Name: ESD Exam");
		System.out.println("Enter Date of Exam: ");
		System.out.println("Enter Date: 20");
		System.out.println("Enter Month Number: 11");
		System.out.println("Enter Year: 2022");
		System.out.println("Enter Hour in 24hr format: 13");
		System.out.println("Enter Minute: 30");
		System.out.println("Date and Time of the Exam: 2022-11-20 13:30:00");
		System.out.println("Test Creation Failed. Exam Timings Conflict with another Exam.");
	}
}