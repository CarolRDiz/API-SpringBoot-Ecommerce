package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/courses/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/courses/create")
    public ResponseEntity<Object> create(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) courseRepository.delete(course.get());
        return new ResponseEntity<>(course.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/courses/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Course course) {
        Optional<Course> oldCourse = courseRepository.findById(id);
        if(oldCourse.isPresent()) {
            //prisoner.setId(id);
            courseRepository.save(course);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}