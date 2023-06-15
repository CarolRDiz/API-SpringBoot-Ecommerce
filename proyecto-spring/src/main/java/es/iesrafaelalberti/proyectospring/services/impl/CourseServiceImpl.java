package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import es.iesrafaelalberti.proyectospring.repositories.UsersRepository;
import es.iesrafaelalberti.proyectospring.services.CourseService;
import es.iesrafaelalberti.proyectospring.services.ImageService;
import es.iesrafaelalberti.proyectospring.services.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    VideoService videoService;
    @Autowired
    ImageService imageService;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public CourseDTO updateCourseByFields(Long id, Map<String, Object> fields){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
           fields.forEach((key,value) -> {
               Field field = ReflectionUtils.findField(Course.class, key);
               field.setAccessible(true);
               ReflectionUtils.setField(field, course.get(), value);
           });
            Course courseSaved = courseRepository.save(course.get());
            CourseDTO courseDTO =  this.mapper.map( courseSaved, CourseDTO.class);
            return courseDTO;
        }
        else{
            throw new NotFoundException("Course not found");
        }
    }
    @Override
    public Course updateMultifiles(Long id, MultipartFile video, MultipartFile image){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            try {
                if(video!=null){
                    //Borra el video anterior
                    gridFsTemplate.delete(new Query(Criteria.where("_id").is(course.get().getVideo_id())));
                    //Guarda el nuevo vídeo y obtiene su id
                    String video_id = videoService.addVideo( course.get().getTitle(), video);
                    //Lo introduce en el chapter
                    Field field = ReflectionUtils.findField(Course.class, "video_id");
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, course.get(), video_id);
                    //return courseRepository.save(course.get());
                }
                if(image!=null){
                    //Borra la imagen anterior
                    if (course.get().getImage_id()!=null){
                        imageService.deleteImage(course.get().getImage_id());
                    }
                    //Guarda la nueva imagen y obtiene su id
                    String image_id = imageService.addImage( course.get().getTitle(), image);
                    //Lo introduce en el chapter
                    Field field = ReflectionUtils.findField(Course.class, "image_id");
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, course.get(), image_id);
                }
                return courseRepository.save(course.get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            throw new NotFoundException("Course not found");
        }
    }

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
