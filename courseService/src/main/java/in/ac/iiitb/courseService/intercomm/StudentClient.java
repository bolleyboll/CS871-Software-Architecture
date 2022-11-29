package in.ac.iiitb.courseService.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("student-service")
public interface StudentClient {
	@RequestMapping(method = RequestMethod.POST, value = "/student/abc", consumes = "application/json")
	String getStr();
}