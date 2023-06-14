package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.LessonCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonDTO;

import java.util.List;

public interface LessonService {
    LessonDTO create(LessonCreateDTO lessonCreateDTO) ;
    List<LessonDTO> findAll();

    void delete(Long id);
}
