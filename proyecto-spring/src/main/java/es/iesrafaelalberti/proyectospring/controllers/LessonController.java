package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.LessonCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Lesson;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.LessonRepository;
import es.iesrafaelalberti.proyectospring.repositories.UsersRepository;
import es.iesrafaelalberti.proyectospring.services.LessonService;
import es.iesrafaelalberti.proyectospring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class LessonController {
    @Autowired
    LessonService lessonService;
    @Autowired
    LessonRepository lessonRepository;

    @GetMapping("/lessons/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(lessonService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/lessons/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(lessonService.findById(id),HttpStatus.OK);
        } catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/lessons/create", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> create(@ModelAttribute LessonCreateDTO lessonCreateDTO) throws IOException {
        return new ResponseEntity<>(
                lessonService.createLesson(lessonCreateDTO),
                HttpStatus.OK);
    }
    /*
    @RequestMapping(path = "/lessons/update", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> update(@ModelAttribute LessonCreateDTO lessonCreateDTO) throws IOException {
        Optional<Lesson> oldLesson = lessonRepository.findById(lessonCreateDTO.getId());
        if(oldLesson.isPresent()) {
            LessonDTO lessonDTO = lessonService.updateLesson(lessonCreateDTO);
            return new ResponseEntity<>(lessonDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    */
    @DeleteMapping("/lessons/{id}/")

    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        HttpStatus httpStatus;
        try {
            lessonService.deleteLesson(id);
            httpStatus = HttpStatus.CREATED;
        } catch (NotFoundException e){
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (Exception e){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }
}
