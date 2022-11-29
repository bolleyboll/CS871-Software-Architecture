package in.ac.iiitb.test.services;

import java.util.List;


import in.ac.iiitb.test.models.Course;
import in.ac.iiitb.test.models.Student;

public interface InterCommService {
	List<Course> getCourses(Student s);
}
