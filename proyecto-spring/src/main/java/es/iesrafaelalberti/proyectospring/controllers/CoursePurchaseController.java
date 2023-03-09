package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.dto.CoursePurchaseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CoursePurchaseDTO;
import es.iesrafaelalberti.proyectospring.models.CoursePurchase;
import es.iesrafaelalberti.proyectospring.repositories.CoursePurchaseRepository;
import es.iesrafaelalberti.proyectospring.services.CoursePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CoursePurchaseController {
    @Autowired
    CoursePurchaseRepository coursePurchaseRepository;
    @Autowired
    CoursePurchaseService coursePurchaseService;
    @GetMapping("/coursePurchases/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(coursePurchaseRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/coursePurchase/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new CoursePurchaseDTO(coursePurchaseRepository.findById(id).get()), HttpStatus.OK);
    }
    @PostMapping("/coursePurchase/create")
    public ResponseEntity<Object> create(@RequestBody CoursePurchaseCreateDTO coursePurchase) {
        return new ResponseEntity<>(
                new CoursePurchaseDTO(coursePurchaseService.coursePurchaseCreate(coursePurchase)),
                HttpStatus.OK);
    }
    @DeleteMapping("/coursePurchase/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<CoursePurchase> coursePurchase = coursePurchaseRepository.findById(id);
        if(coursePurchase.isPresent()) coursePurchaseRepository.delete(coursePurchase.get());
        return new ResponseEntity<>(coursePurchase.isPresent(), HttpStatus.OK);
    }
    @PutMapping("/coursePurchase/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody CoursePurchase coursePurchase) {
        Optional<CoursePurchase> oldCoursePurchase = coursePurchaseRepository.findById(id);
        if(oldCoursePurchase.isPresent()) {
            //prisoner.setId(id);
            coursePurchaseRepository.save(coursePurchase);
            return new ResponseEntity<>(coursePurchase, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}