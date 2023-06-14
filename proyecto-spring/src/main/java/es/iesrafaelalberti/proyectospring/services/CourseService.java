package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.models.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {
    CourseDTO create(CourseCreateDTO courseCreateDTO, String username) ;
    List<CourseDTO> findAll();

    Course updateCourseByFields(Long id, Map<String, Object> fields);

    void delete(Long id);
    CourseDTO findById(Long id);
}
