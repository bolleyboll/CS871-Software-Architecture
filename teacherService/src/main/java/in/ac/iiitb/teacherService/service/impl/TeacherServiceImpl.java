package in.ac.iiitb.teacherService.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.iiitb.teacherService.models.Teacher;
import in.ac.iiitb.teacherService.repositories.TeacherRepository;
import in.ac.iiitb.teacherService.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	HttpSession httpSession;

	@Autowired
	TeacherRepository tr;

	@Override
	public String getSessionKey(String key) {
		return (httpSession.getAttribute(key) != null) ? (String) httpSession.getAttribute(key) : "null";
	}

	@Override
	public Boolean setSessionKey(String key, Teacher s) {
		try {
			httpSession.setAttribute(key, s.getUsername());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Teacher findByUsername(String uname) {
		try {
			Teacher s = tr.findByUsername(uname);
			return s;
		} catch (Exception e) {
			return new Teacher();
		}
	}
}