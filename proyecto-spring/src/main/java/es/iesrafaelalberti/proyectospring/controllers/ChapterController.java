package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    @Autowired
    ChapterRepository chapterRepository;

    @RequestMapping(path = "/chapters/{id}/", method = PATCH)
    public Chapter update(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return chapterService.updateChapterByFields(id, fields);
        //return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
    @RequestMapping(path = "/chapters/video/{id}/", method = PATCH, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Chapter updateVideo(@PathVariable Long id, @RequestParam("file") MultipartFile file, Model model){
        return chapterService.updateVideo(id, file);
        //return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }


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
