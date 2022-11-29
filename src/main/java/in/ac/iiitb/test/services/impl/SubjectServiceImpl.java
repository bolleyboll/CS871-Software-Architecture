package in.ac.iiitb.test.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import in.ac.iiitb.test.models.Subject;
import in.ac.iiitb.test.repositories.SubjectRepository;
import in.ac.iiitb.test.services.SubjectService;

public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectRepository subr;
	
	@Override
	public boolean findByCourseCode(String subCode) {
		Subject sub = subr.findBySubjectCode(subCode);
		if(sub == null){
			return false;
		}
		return true;
	}
	
}
