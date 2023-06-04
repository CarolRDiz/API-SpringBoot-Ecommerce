package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(path = "/courses/", method = POST)
    public ResponseEntity<Object> create(@RequestBody CourseCreateDTO newCourse){
        return new ResponseEntity<>(courseService.create(newCourse), HttpStatus.CREATED);
    }
    @GetMapping("/courses/")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

}
