package es.iesrafaelalberti.proyectospring.controllers;
import es.iesrafaelalberti.proyectospring.dto.ValuationCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ValuationDTO;
import es.iesrafaelalberti.proyectospring.models.UserReview;
import es.iesrafaelalberti.proyectospring.repositories.ValuationRepository;
import es.iesrafaelalberti.proyectospring.services.ValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ValuationController {
    @Autowired
    ValuationRepository valuationRepository;
    @Autowired
    ValuationService valuationService;
    @GetMapping("/valuations/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(valuationRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/valuations/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ValuationDTO(valuationRepository.findById(id).get()), HttpStatus.OK);
    }
    @PostMapping("/valuations/create")
    public ResponseEntity<Object> create(@RequestBody ValuationCreateDTO valuation) {
        return new ResponseEntity<>(
                new ValuationDTO(valuationService.valuationCreate(valuation)),
                HttpStatus.OK);
    }
    @DeleteMapping("/valuations/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<UserReview> valuation = valuationRepository.findById(id);
        if(valuation.isPresent()) valuationRepository.delete(valuation.get());
        return new ResponseEntity<>(valuation.isPresent(), HttpStatus.OK);
    }
    @PutMapping("/valuations/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody UserReview userReview) {
        Optional<UserReview> oldValuation = valuationRepository.findById(id);
        if(oldValuation.isPresent()) {
            valuationRepository.save(userReview);
            return new ResponseEntity<>(userReview, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}