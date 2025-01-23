package classboxes.microservices.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface SchoolRepository extends JpaRepository<School, Integer> {}