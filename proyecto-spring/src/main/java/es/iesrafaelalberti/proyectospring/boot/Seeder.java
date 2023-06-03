package es.iesrafaelalberti.proyectospring.boot;

import es.iesrafaelalberti.proyectospring.factories.*;
import es.iesrafaelalberti.proyectospring.models.*;
import es.iesrafaelalberti.proyectospring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CoursePurchaseRepository coursePurchaseRepository;
    @Autowired
    ValuationRepository valuationRepository;

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
        List<Users> users = usersFactory.get(3);
        Users user = new Users("FirstUser", "SurnameFirstUser", "emailfirstuser@email.com", "password");
        usersRepository.save(user);
        usersRepository.saveAll(users);
        /* Course */
        List<Course> courses = courseFactory.get(3);
        Course course = new Course("FirstCourse", "Author", 1.0, 1, 1, "es", "es", "area", "subarea", "level", "date");
        courseRepository.save(course);
        courseRepository.saveAll(courses);
        /* CoursePurchase */
        coursePurchaseRepository.save(new CoursePurchase(new HashSet<>(courses), user));
        coursePurchaseRepository.saveAll(coursePurchaseFactory.get(3, new HashSet<>(courses), users));
        valuationRepository.saveAll(valuationFactory.get(3, courses, users));
    }}