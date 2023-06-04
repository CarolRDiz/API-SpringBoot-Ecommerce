package es.iesrafaelalberti.proyectospring.repositories;

import es.iesrafaelalberti.proyectospring.models.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
