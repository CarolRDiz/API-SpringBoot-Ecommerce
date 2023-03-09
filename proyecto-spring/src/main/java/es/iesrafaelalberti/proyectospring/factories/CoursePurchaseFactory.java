package es.iesrafaelalberti.proyectospring.factories;
import com.github.javafaker.Faker;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.CoursePurchase;
import es.iesrafaelalberti.proyectospring.models.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CoursePurchaseFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));

    public List<CoursePurchase> get(int number, List<Course> courses, List<Users> users ) {
        Random rand = new Random();
        return IntStream.range(0, number)
                .mapToObj(x -> new CoursePurchase(
                        courses.get(rand.nextInt(courses.size())),
                        users.get(rand.nextInt(users.size()))
                        ))
                .collect(Collectors.toList());
    }
}
