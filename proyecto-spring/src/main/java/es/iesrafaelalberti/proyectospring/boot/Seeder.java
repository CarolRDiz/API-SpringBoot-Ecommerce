package es.iesrafaelalberti.proyectospring.boot;


import es.iesrafaelalberti.proyectospring.models.Users;

import es.iesrafaelalberti.proyectospring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    UsersRepository userRepository;

    @Override
    public void run(String... args) {
        Users testUser = new Users(1L,"carol", "{noop}password", true);
        Users testUser2 = new Users(2L,"noad", "{noop}password", false);
        userRepository.save(testUser);
        userRepository.save(testUser2);

    }
}