package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.LessonCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonDTO;
import es.iesrafaelalberti.proyectospring.models.Lesson;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface LessonService extends Serializable {
    LessonDTO findById(Long id);
    LessonDTO createLesson(LessonCreateDTO lessonCreateDTO) throws IOException;
    //LessonDTO updateLesson(LessonCreateDTO lessonCreateDTO) throws IOException;
    void deleteLesson(Long id);
    //LessonDTO updateLesson(LessonCreateDTO lessonCreateDTO) throws IOException;
    List<LessonDTO> findAll();
}
