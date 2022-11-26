package in.ac.iiitb.studentService.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.iiitb.studentService.models.Student;
import in.ac.iiitb.studentService.repositories.StudentRepository;
import in.ac.iiitb.studentService.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	HttpSession httpSession;

	@Autowired
	StudentRepository sr;

	@Override
	public String getSessionKey(String key) {
		return (httpSession.getAttribute(key) != null) ? (String) httpSession.getAttribute(key) : "null";
	}

	@Override
	public Boolean setSessionKey(String key, Student s) {
		try {
			httpSession.setAttribute(key, s.getUsername());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Student findByUsername(String uname) {
		try {
			Student s = sr.findByUsername(uname);
			return s;
		} catch (Exception e) {
			return new Student();
		}
	}
}