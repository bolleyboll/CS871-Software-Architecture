package in.ac.iiitb.courseService.controller;

import java.util.ArrayList;
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
		ExamResponse resp = cs.saveTestResponse(examResp);
		return ResponseEntity.ok(resp);
	}

	@PostMapping("tests/save/{cid}")
	public ResponseEntity<Exam> saveExam(@RequestBody Exam exam, @PathVariable String cid) {
		Course c = cr.findByCourseCode(cid);
		exam.setCourseCode(c);
		Exam resp = cs.saveExam(exam);
		return ResponseEntity.ok(resp);
	}

	@GetMapping("all")
	public ResponseEntity<List<Course>> allCourses() {
		List<Course> resp = cs.allCourses();
		return ResponseEntity.ok(resp);
	}
}