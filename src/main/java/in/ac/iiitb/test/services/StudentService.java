package in.ac.iiitb.test.services;

import in.ac.iiitb.test.models.Student;

public interface StudentService {
	String getSessionKey(String key);

	Boolean setSessionKey(String key, Student s);

	Student findByUsername(String uname);
}
