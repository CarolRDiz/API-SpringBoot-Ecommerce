package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.models.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CourseService {
    //Course updateVideo(Long id, MultipartFile file);

    CourseDTO create(CourseCreateDTO courseCreateDTO, String username) ;
    List<CourseDTO> findAll();

    Course updateCourseByFields(Long id, Map<String, Object> fields);

    void delete(Long id);
    CourseDTO findById(Long id);
}
