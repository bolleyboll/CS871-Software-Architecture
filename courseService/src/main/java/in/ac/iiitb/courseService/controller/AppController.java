package in.ac.iiitb.courseService.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ac.iiitb.courseService.intercomm.StudentClient;
import in.ac.iiitb.courseService.models.Course;
import in.ac.iiitb.courseService.models.CourseRegistration;
import in.ac.iiitb.courseService.models.Exam;
import in.ac.iiitb.courseService.models.ExamResponse;
import in.ac.iiitb.courseService.repositories.CourseRepository;
import in.ac.iiitb.courseService.repositories.ExamRepository;
import in.ac.iiitb.courseService.service.CourseService;

@RestController
@RequestMapping("course")
public class AppController {

	@Autowired
	CourseService cs;

	@Autowired
	StudentClient sc;

	@Autowired
	CourseRepository cr;

	@Autowired
	ExamRepository er;

	@GetMapping("tests/{student}")
	public ResponseEntity<ArrayList<Exam>> findStudentsOfCourse(@PathVariable String student) {
		List<CourseRegistration> courses = cs.getTests(student);
		ArrayList<Course> subs = new ArrayList<Course>();
		ArrayList<Exam> exams = new ArrayList<>();

		for (CourseRegistration cou : courses) {
			subs.add(cou.getCourse());
		}

		for (Course su : subs) {
			ArrayList<Exam> temporary;
			temporary = cs.findByCourseCode(su);

			for (Exam e : temporary) {
				exams.add(e);
			}
		}

		return ResponseEntity.ok(exams);
	}

	@PostMapping("tests/response/save")
	public ResponseEntity<ExamResponse> saveExamResponse(@RequestBody ExamResponse examResp) {
		Exam e = examResp.getExam();
		Instant startTime = e.getStartDate().toInstant();
		Instant endTime = startTime.plusSeconds(e.getDuration() * 60);

		Instant curr = new Date().toInstant();
		if (curr.isAfter(startTime) && curr.isBefore(endTime)) {
			ExamResponse resp = cs.saveTestResponse(examResp);
			return ResponseEntity.ok(resp);
		} else {
			return ResponseEntity.ok(new ExamResponse());
		}
	}

	@PostMapping("tests/save/{cid}")
	public ResponseEntity<Exam> saveExam(@RequestBody Exam exam, @PathVariable String cid) {
		Course c = cr.findByCourseCode(cid);
		exam.setCourseCode(c);

		boolean f = false;

		Instant d = exam.getStartDate().toInstant();
		d = d.minusSeconds(19800);

		exam.setStartDate(Date.from(d));

		List<Exam> tests = er.findAll();
		for (Exam test : tests) {
			Instant startTime = exam.getStartDate().toInstant();
			Instant endTime = startTime.plusSeconds(exam.getDuration() * 60);

			Instant startExamTime = test.getStartDate().toInstant();
			Instant endExamTime = startExamTime.plusSeconds(test.getDuration() * 60);

			if ((startTime.isBefore(startExamTime) && endTime.isBefore(startExamTime))
					|| (startTime.isAfter(endExamTime) && endTime.isAfter(endExamTime))) {
				f = true;
			}

		}
		if (f) {
			Exam resp = cs.saveExam(exam);
			return ResponseEntity.ok(resp);
		}
		return ResponseEntity.ok(new Exam());
	}

	@GetMapping("all")
	public ResponseEntity<List<Course>> allCourses() {
		List<Course> resp = cs.allCourses();
		return ResponseEntity.ok(resp);
	}
}