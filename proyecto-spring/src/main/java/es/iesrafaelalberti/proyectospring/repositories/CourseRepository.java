package es.iesrafaelalberti.proyectospring.repositories;

import es.iesrafaelalberti.proyectospring.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
