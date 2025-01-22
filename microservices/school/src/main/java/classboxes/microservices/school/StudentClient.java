package classboxes.microservices.school;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
	name = "student-service",
	url = "${application.config.student-url}"
)
public interface StudentClient {
	@GetMapping("/school/{school-id}")
	List<Student> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);
}