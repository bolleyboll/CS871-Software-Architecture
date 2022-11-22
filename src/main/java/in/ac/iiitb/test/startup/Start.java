package in.ac.iiitb.test.startup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
			System.out.println("Login Successful");

			List<CourseRegistration> courses = crr.findByStudent(s);
			ArrayList<Subject> subs = new ArrayList<Subject>();
			ArrayList<Test> tests = new ArrayList<>();

			for (CourseRegistration cou : courses) {
				subs.add(cou.getCourse());
			}

			for (Subject su : subs) {
				ArrayList<Test> temporary;
				temporary = tr.findByCourseCode(su);

				for (Test t : temporary) {
					tests.add(t);
				}
			}
			System.out.println("Tests:");
			int i = 1;
			for (Test tes : tests) {
				System.out.println(i++ + ". " + tes.getName());
			}
			System.out.print("Enter your Choice: ");
			int testNo = Integer.parseInt(br.readLine());

			if (testNo < i) {
				Instant startDB = tests.get(testNo-1).getStartDate().toInstant();
				Instant endDB = startDB.plusSeconds(tests.get(testNo-1).getDuration()*60);

				Instant now = Instant.now();
				if (now.isAfter(startDB) && now.isBefore(endDB)) {
					System.out.println("\nYou've entered the test!");
				} else {
					System.out.println("Unable to enter exam. Exam has already Ended.");
				}

			} else {
				System.out.println("Incorrect Choice.");
			}

		} else {
			System.out.println("Login Unsuccessful");
		}
	}

	void teach() throws Exception {

		Test t = new Test();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("---Create a New Test---\n");

		System.out.print("Enter Test Name: ");
		String name;
		name = br.readLine();
		t.setName(name);

		System.out.println("Enter Date of Exam: ");
		int date, month, year, hr, minute;

		System.out.print("Enter Date: ");
		date = Integer.parseInt(br.readLine());
		System.out.print("Enter Month Number: ");
		month = Integer.parseInt(br.readLine());
		System.out.print("Enter Year: ");
		year = Integer.parseInt(br.readLine());
		System.out.print("Enter Hour in 24hr format: ");
		hr = Integer.parseInt(br.readLine());
		System.out.print("Enter Minute: ");
		minute = Integer.parseInt(br.readLine());

		String dateString = year + "/" + month + "/" + date + " " + hr + ":" +
				minute;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d = formatter.parse(dateString);
		System.out.println("Date and Time of the Exam: " + d);
		t.setStartDate(d);

		System.out.print("Enter Duration of the Exam: ");
		int duration;
		duration = Integer.parseInt(br.readLine());
		t.setDuration(duration);
		boolean flag = true;
		while (flag) {
			System.out.print("Enter Subject Code: ");
			String cc;
			cc = br.readLine();
			Subject sub = subr.findBySubjectCode(cc);
			if (sub != null) {
				t.setCourseCode(sub);
				flag = false;
			} else {
				System.out.println("Incorrect Code, no Subject with that Subject Code Exists!!");
			}
		}

		List<Test> tests = tr.findAll();
		for (Test test : tests) {
			Instant startTime = t.getStartDate().toInstant();
			Instant endTime = startTime.plusSeconds(t.getDuration() * 60);

			Instant startExamTime = test.getStartDate().toInstant();
			Instant endExamTime = startExamTime.plusSeconds(t.getDuration() * 60);

			if ((startTime.isBefore(startExamTime) && endTime.isBefore(startExamTime))
					|| (startTime.isAfter(endExamTime) && endTime.isAfter(endExamTime))) {
				tr.save(t);
			} else {
				System.out.println("Test Creation Failed. Exam Timings Conflict with another Exam.");
				System.out.println(test);
				break;
			}
		}

	}

	@EventListener(ContextRefreshedEvent.class)
	void start() throws Exception {
		int choice;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
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
			t.setDuration(5);
			t.setCourseCode(sub);
			t.setStartDate(d);
			t.setTestId(1);
			tr.save(t);
		} catch (Exception e) {
			System.out.println("Already Existing data");
		}

		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.println("---Welcome to OAES---\n\n");
		System.out.println("1. Student Login\n2. Teacher Login");
		System.out.println("Enter your Choice");
		choice = Integer.parseInt(br.readLine());
		switch (choice) {
			case 1:
				studentLogin();
				break;
			case 2:
				teach();
				break;
			default:
				System.out.println("Invalid Option");
				break;
		}
	}
}