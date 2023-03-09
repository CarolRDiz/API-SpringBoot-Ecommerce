package es.iesrafaelalberti.proyectospring.boot;

import es.iesrafaelalberti.proyectospring.factories.*;
import es.iesrafaelalberti.proyectospring.models.*;
import es.iesrafaelalberti.proyectospring.repositories.*;
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
    UsersRepository usersRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CoursePurchaseRepository coursePurchaseRepository;
    @Autowired
    ValuationRepository valuationRepository;
    @Autowired
    PrisonerFactory prisonerFactory;
    @Autowired
    CellFactory cellFactory;
    @Autowired
    UsersFactory usersFactory;
    @Autowired
    CourseFactory courseFactory;
    @Autowired
    CoursePurchaseFactory coursePurchaseFactory;
    @Autowired
    ValuationFactory valuationFactory;
    @Override
    public void run(String... args) {
        List<Cell> cells = cellFactory.get(3);
        cellRepository.saveAll(cells);
        prisonerRepository.save(new Prisoner("bob", 19, 23, cells.get(0)));
        prisonerRepository.saveAll(prisonerFactory.get(7, cells));

        List<Users> users = usersFactory.get(3);
        Users user = new Users("FirstUser", "SurnameFirstUser", "emailfirstuser@email.com", "password");
        usersRepository.save(user);
        usersRepository.saveAll(users);
        List<Course> courses = courseFactory.get(3);
        Course course = new Course("FirstCourse", "Author", 1.0, 1, 1, "es", "es", "area", "subarea", "level", "date");
        courseRepository.save(course);
        courseRepository.saveAll(courses);
        coursePurchaseRepository.save(new CoursePurchase(course, user));
        coursePurchaseRepository.saveAll(coursePurchaseFactory.get(3, courses, users));
        valuationRepository.saveAll(valuationFactory.get(3, courses, users));
    }}