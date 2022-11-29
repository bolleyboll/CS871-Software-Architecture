package in.ac.iiitb.test.services;

import in.ac.iiitb.test.models.Teacher;

public interface TeacherService {
	String getSessionKey(String key);

	Boolean setSessionKey(String key, Teacher s);

	Teacher findByUsername(String uname);
}
