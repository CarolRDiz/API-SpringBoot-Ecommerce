package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.LessonCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Lesson;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.repositories.LessonRepository;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import es.iesrafaelalberti.proyectospring.services.LessonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    CourseRepository courseRepository;

    private ModelMapper mapper = new ModelMapper();
    @Override
    public LessonDTO create(LessonCreateDTO newChapter){
        Optional<Course> course = courseRepository.findById(newChapter.getCourse_id());
        if(course.isPresent()){
            Lesson lesson = new Lesson(course.get(), newChapter.getTitle());
            Lesson lessonSaved = lessonRepository.save(lesson);
            return new LessonDTO(lessonSaved);
        }
        else {
            throw new NotFoundException("Course not found");
        }

    }
    @Override
    public List<LessonDTO> findAll() {
        List<Lesson> lessons = lessonRepository.findAll();
        List<LessonDTO> dtos = lessons
                .stream()
                .map(lesson -> mapper.map(lesson, LessonDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }
    @Override
    public void delete(Long id){
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if(lesson.isPresent()) lessonRepository.delete(lesson.get());
        else{
            throw new NotFoundException("Lesson not found");
        }
    }
}
