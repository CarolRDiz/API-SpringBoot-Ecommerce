package es.iesrafaelalberti.proyectospring.boot;

import es.iesrafaelalberti.proyectospring.factories.CellFactory;
import es.iesrafaelalberti.proyectospring.factories.PrisonerFactory;
import es.iesrafaelalberti.proyectospring.factories.UserFactory;
import es.iesrafaelalberti.proyectospring.factories.CourseFactory;
import es.iesrafaelalberti.proyectospring.models.Cell;
import es.iesrafaelalberti.proyectospring.repositories.PrisonerRepository;
import es.iesrafaelalberti.proyectospring.repositories.CellRepository;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import es.iesrafaelalberti.proyectospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    PrisonerRepository prisonerRepository;
    @Autowired
    CellRepository cellRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    PrisonerFactory prisonerFactory;
    @Autowired
    CellFactory cellFactory;
    @Autowired
    UserFactory userFactory;
    @Autowired
    CourseFactory courseFactory;
    @Override
    public void run(String... args) {
        List<Cell> cells = cellFactory.get(3);
        cellRepository.saveAll(cells);
        prisonerRepository.saveAll(prisonerFactory.get(7, cells));
        userRepository.saveAll(userFactory.get(5));
        courseRepository.saveAll(courseFactory.get(5));
    }}