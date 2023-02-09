package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.models.User;
import es.iesrafaelalberti.proyectospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public ResponseEntity<Object> create(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) userRepository.delete(user.get());
        return new ResponseEntity<>(user.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> oldUser = userRepository.findById(id);
        if(oldUser.isPresent()) {
            //prisoner.setId(id);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}