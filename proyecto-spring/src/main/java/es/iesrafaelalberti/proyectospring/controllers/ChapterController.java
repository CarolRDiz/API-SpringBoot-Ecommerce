package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.repositories.LessonRepository;
import es.iesrafaelalberti.proyectospring.services.ChapterService;
import es.iesrafaelalberti.proyectospring.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    @Autowired
    ChapterRepository chapterRepository;

    @RequestMapping(path = "/chapters/", method = POST)
    public ResponseEntity<Object> create(@RequestBody ChapterCreateDTO newChapter){
        return new ResponseEntity<>(
                chapterService.create(newChapter),
                HttpStatus.OK);
    }
    @GetMapping("/chapters/")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(chapterService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/chapters/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        HttpStatus httpStatus;
        try {
            chapterService.delete(id);
            httpStatus = HttpStatus.CREATED;
        } catch (NotFoundException e){
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (Exception e){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }
}
