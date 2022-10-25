package in.ac.iiitb.dao;

import in.ac.iiitb.models.Student;

public interface StudentService {
	public Student findStudentByUsername(String uname);
	public Student findStudentByEmail(String email);
	public String save(Student s);
}