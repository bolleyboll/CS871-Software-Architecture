package in.ac.iiitb.studentService.service;

import in.ac.iiitb.studentService.models.Student;

public interface StudentService {
	String getSessionKey(String key);

	Boolean setSessionKey(String key, Student s);

	Student findByUsername(String uname);
}
