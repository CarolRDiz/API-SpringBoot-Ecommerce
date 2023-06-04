package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import es.iesrafaelalberti.proyectospring.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    private ModelMapper mapper = new ModelMapper();
    @Override
    public CourseDTO create(CourseCreateDTO newCourse){
        Course course = mapper.map( newCourse, Course.class);
        Course courseSaved = courseRepository.save(course);
        CourseDTO courseDTO =  mapper.map( courseSaved, CourseDTO.class);
        return courseDTO;
    }
    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> dtos = courses
                .stream()
                .map(course -> mapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }
    @Override
    public void delete(Long id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) courseRepository.delete(course.get());
        else{
            throw new NotFoundException("Course not found");
        }
    }
}
