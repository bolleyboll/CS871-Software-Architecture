package in.ac.iiitb.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ac.iiitb.test.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String> {
	Subject findBySubjectId(Integer id);

	boolean deleteBySubjectCode(String subCode);

	Subject findBySubjectCode(String subCode);
}