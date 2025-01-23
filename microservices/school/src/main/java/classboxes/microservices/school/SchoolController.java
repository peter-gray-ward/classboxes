package classboxes.microservices.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
	private final SchoolService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody School school) {
		System.out.println("[time] - - - Getting a Request");
		service.save(school);
	}

	@GetMapping
	public ResponseEntity<List<School>> findAllSchools() {
		return ResponseEntity.ok(service.findAllSchools());
	}

	@GetMapping("/with-students/{school-id}")
	public ResponseEntity<FullSchoolResponse> findSchoolsWithStudents(@PathVariable("school-id") Integer schoolId) {
		return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
	}
}