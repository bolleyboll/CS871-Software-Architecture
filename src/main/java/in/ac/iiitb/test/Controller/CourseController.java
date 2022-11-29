package in.ac.iiitb.test.Controller;
import in.ac.iiitb.test.services.CourseService;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import in.ac.iiitb.courseService.intercomm.StudentClient;
import in.ac.iiitb.test.models.Course;
import in.ac.iiitb.test.models.CourseRegistration;
import in.ac.iiitb.test.models.Exam;
import in.ac.iiitb.test.models.ExamResponse;
import in.ac.iiitb.test.repositories.CourseRepository;


@RestController
@CrossOrigin
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseService cs;

	//@Autowired
//	StudentClient sc;

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