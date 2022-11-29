package in.ac.iiitb.test.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.test.models.Subject;
import in.ac.iiitb.test.models.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {
	Test findByTestId(Integer id);

	boolean deleteByTestId(Integer id);

	ArrayList<Test> findByCourseCode(Subject courseCode);
}