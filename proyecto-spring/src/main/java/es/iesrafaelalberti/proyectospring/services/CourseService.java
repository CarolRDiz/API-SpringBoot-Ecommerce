package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO create(CourseCreateDTO courseCreateDTO) ;
    List<CourseDTO> findAll();

    //void delete(Long id);
}
