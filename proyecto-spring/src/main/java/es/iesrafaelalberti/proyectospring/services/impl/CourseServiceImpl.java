package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import es.iesrafaelalberti.proyectospring.repositories.UsersRepository;
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
    @Autowired
    UsersRepository usersRepository;

    private ModelMapper mapper = new ModelMapper();
    @Override
    public CourseDTO create(CourseCreateDTO newCourse, String username){

        Optional<Users> author = usersRepository.findByUsername(username);
        if (author.isPresent()){
            newCourse.setAuthor(author.get());
            Course course = new Course(newCourse.getTitle(),newCourse.getAuthor());
            Course courseSaved = courseRepository.save(course);
            CourseDTO courseDTO =  this.mapper.map( courseSaved, CourseDTO.class);
            return courseDTO;
        }
        else{
            throw new NotFoundException("El usuario no existe");
        }
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
    @Override
    public CourseDTO findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            return mapper.map(course, CourseDTO.class);
        }
        else{
            throw new NotFoundException("Course not found");
        }
    }
}
