package br.com.alura.forum.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import br.com.alura.forum.model.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void shouldReturnCourseFindByName() {
		String courseName = "HTML 5";
		Course html5 = new Course();
		html5.setName(courseName);
		html5.setCategory("Programação");
		entityManager.persist(html5);

		Course course = courseRepository.findByName(courseName);

		Assert.notNull(course, "The class must not be null");
		Assert.hasText(course.getName(), courseName);
	}

	@Test
	public void shouldNotReturnCourseFindByNameWhenCourseNotExists() {
		String courseName = "JPA";

		Course course = courseRepository.findByName(courseName);

		Assert.isNull(course, "The class must be null");
	}

}
