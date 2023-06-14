package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    @Autowired
    ChapterRepository chapterRepository;

    @GetMapping("/chapters/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(chapterService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/chapters/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(chapterService.findById(id),HttpStatus.OK);
        } catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/chapters/create", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> create(@ModelAttribute ChapterCreateDTO chapterCreateDTO) throws IOException {
        return new ResponseEntity<>(
                chapterService.createChapter(chapterCreateDTO),
                HttpStatus.OK);
    }
    /*
    @RequestMapping(path = "/lessons/update/{id}", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @ModelAttribute ChapterCreateDTO lessonCreateDTO) throws IOException {
        Optional<Chapter> oldLesson = chapterRepository.findById(id);
        if(oldLesson.isPresent()) {
            ChapterDTO lessonDTO = chapterService.updateLesson(lessonCreateDTO);
            return new ResponseEntity<>(lessonDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    */
    @DeleteMapping("/chapters/{id}/")

    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        HttpStatus httpStatus;
        try {
            chapterService.deleteChapter(id);
            httpStatus = HttpStatus.CREATED;
        } catch (NotFoundException e){
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (Exception e){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }
}
