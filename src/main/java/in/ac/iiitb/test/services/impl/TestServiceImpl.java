package in.ac.iiitb.test.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import in.ac.iiitb.test.models.Test;
import in.ac.iiitb.test.repositories.TestRepository;
import in.ac.iiitb.test.services.TestService;

public class TestServiceImpl implements TestService{

	@Autowired
	TestRepository tr;

	@Override
	public Test saveTest(Test t) {
		return tr.save(t);
	}
	
}
