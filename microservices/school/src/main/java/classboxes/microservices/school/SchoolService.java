package classboxes.microservices.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
	public final SchoolRepository repository;
	public final StudentClient client;

	public void save(School school) {
		repository.save(school);
	}

	public List<School> findAllSchools() {
		return repository.findAll();
	}

	public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
		School school = repository.findById(schoolId)
			.orElse(
				School.builder()
					.name("NOT_FOUND")
					.email("NOT_FOUND")
					.build()
			);
		List<Student> students = client.findAllStudentsBySchool(schoolId);
		return FullSchoolResponse.builder()
			.name(school.getName())
			.email(school.getEmail())
			.students(students)
			.build();
	}
}