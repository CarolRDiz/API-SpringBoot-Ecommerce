package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.UsersRepository;
import es.iesrafaelalberti.proyectospring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<UsersDTO> show(@PathVariable("id") Long id) {
        final UsersDTO usersDTO = usersService.findById(id);
        if (usersDTO ==  null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(usersDTO);
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
        if(user.isPresent()) {
            usersService.delete(id);
            return new ResponseEntity<>(user.isPresent(), HttpStatus.OK);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
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