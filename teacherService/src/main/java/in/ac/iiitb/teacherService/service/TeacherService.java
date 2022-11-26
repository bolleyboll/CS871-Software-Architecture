package in.ac.iiitb.teacherService.service;

import in.ac.iiitb.teacherService.models.Teacher;

public interface TeacherService {
	String getSessionKey(String key);

	Boolean setSessionKey(String key, Teacher s);

	Teacher findByUsername(String uname);
}
