package in.ac.iiitb.courseService.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.iiitb.courseService.models.Course;
import in.ac.iiitb.courseService.models.CourseRegistration;
import in.ac.iiitb.courseService.models.Exam;
import in.ac.iiitb.courseService.models.ExamResponse;
import in.ac.iiitb.courseService.repositories.CourseRegistrationRepository;
import in.ac.iiitb.courseService.repositories.CourseRepository;
import in.ac.iiitb.courseService.repositories.ExamRepository;
import in.ac.iiitb.courseService.repositories.ExamResponseRepository;
import in.ac.iiitb.courseService.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRegistrationRepository crr;

	@Autowired
	ExamRepository exmr;

	@Autowired
	ExamResponseRepository exmrespr;

	@Autowired
	CourseRepository cr;


	@Override
	public List<CourseRegistration> getTests(String student) {
		return crr.findByStudent(student);
	}

	@Override
	public ArrayList<Exam> findByCourseCode(Course c) {
		return exmr.findByCourseCode(c);
	}

	@Override
	public ExamResponse saveTestResponse(ExamResponse examResp) {
		return exmrespr.save(examResp);
	}

	@Override
	public List<Course> allCourses() {
		return cr.findAll();
	}

	@Override
	public Exam saveExam(Exam exam) {
		return exmr.save(exam);
	}
	
}