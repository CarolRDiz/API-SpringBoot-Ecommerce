package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(path = "/courses/", method = POST)
    public ResponseEntity<Object> create(@RequestBody CourseCreateDTO newCourse, Principal principal){
        String username = principal.getName();
        return new ResponseEntity<>(courseService.create(newCourse, username), HttpStatus.CREATED);
        //return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
    @PatchMapping(value = "/courses/{id}/")
    public Course update(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return courseService.updateCourseByFields(id, fields);
        //return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @GetMapping("/courses/")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/courses/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        HttpStatus httpStatus;
        try {
            courseService.delete(id);
            httpStatus = HttpStatus.CREATED;
        } catch (NotFoundException e){
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (Exception e){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }
}
