package in.ac.iiitb.test.services;

import org.springframework.stereotype.Service;

import in.ac.iiitb.test.models.Test;

@Service
public interface TestService {
	Test saveTest(Test t);

}
