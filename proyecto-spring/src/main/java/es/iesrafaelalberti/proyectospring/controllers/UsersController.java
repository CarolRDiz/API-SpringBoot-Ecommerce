package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersDTO;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.UsersRepository;
import es.iesrafaelalberti.proyectospring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersService usersService;

    @GetMapping("/users/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(usersRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new UsersDTO(usersRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public ResponseEntity<Object> create(@RequestBody UsersCreateDTO users) {
        return new ResponseEntity<>(
                new UsersDTO(usersService.usersCreate(users)),
                HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if(user.isPresent()) usersRepository.delete(user.get());
        return new ResponseEntity<>(user.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Users users) {
        Optional<Users> oldUser = usersRepository.findById(id);
        if(oldUser.isPresent()) {
            //prisoner.setId(id);
            usersRepository.save(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}