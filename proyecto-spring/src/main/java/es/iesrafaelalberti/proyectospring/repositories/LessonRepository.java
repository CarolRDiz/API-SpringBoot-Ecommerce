package es.iesrafaelalberti.proyectospring.repositories;

import es.iesrafaelalberti.proyectospring.models.Lesson;
import es.iesrafaelalberti.proyectospring.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LessonRepository extends MongoRepository<Lesson, Long> {
}
