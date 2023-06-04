package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.repositories.LessonRepository;
import es.iesrafaelalberti.proyectospring.services.ChapterService;
import es.iesrafaelalberti.proyectospring.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
}
